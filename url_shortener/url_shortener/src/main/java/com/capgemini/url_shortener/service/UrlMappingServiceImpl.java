package com.capgemini.url_shortener.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.url_shortener.dto.StatsDto;
import com.capgemini.url_shortener.dto.UrlRequestDto;
import com.capgemini.url_shortener.dto.UrlResponseDto;
import com.capgemini.url_shortener.entity.UrlMapping;
import com.capgemini.url_shortener.exception.ShortCodeAlreadyExistsException;
import com.capgemini.url_shortener.exception.ShortCodeNotFoundException;
import com.capgemini.url_shortener.repository.UrlMappingRepository;

import lombok.RequiredArgsConstructor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlMappingServiceImpl implements UrlMappingService {

    private final UrlMappingRepository repository;

    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 6;
    private final Random random = new Random();

    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }

    @Override
    @Transactional
    public UrlResponseDto createShortUrl(UrlRequestDto request) {

        String code = request.getCustomAlias();

        if (code != null && repository.existsByShortCode(code)) {
            throw new ShortCodeAlreadyExistsException("Custom alias already exists");
        }

        if (code == null || code.isBlank()) {
            do {
                code = generateCode();
            } while (repository.existsByShortCode(code));
        }

        UrlMapping entity = new UrlMapping();
        entity.setOriginalUrl(request.getOriginalUrl());
        entity.setShortCode(code);

        repository.save(entity);

        return mapToDto(entity);
    }

    @Override
    @Transactional
    public String resolveAndIncrement(String shortCode) {

        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new ShortCodeNotFoundException("Short code not found"));

        mapping.setClickCount(mapping.getClickCount() + 1);
        repository.save(mapping);

        return mapping.getOriginalUrl();
    }

    @Override
    public StatsDto getStats(String shortCode) {
        UrlMapping m = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new ShortCodeNotFoundException("Short code not found"));

        return new StatsDto(
                m.getShortCode(),
                m.getOriginalUrl(),
                m.getClickCount(),
                m.getCreatedAt(),
                m.getUpdatedAt()
        );
    }

    @Override
    public Page<UrlResponseDto> getAll(int page, int size) {
        Page<UrlMapping> result = repository.findAll(PageRequest.of(page, size));
        return result.map(this::mapToDto);
    }

    @Override
    public void delete(String shortCode) {
        UrlMapping m = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new ShortCodeNotFoundException("Short code not found"));
        repository.delete(m);
    }

    @Override
    public List<UrlResponseDto> getTop5() {
        return repository.findTop5ByClickCountDesc()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private UrlResponseDto mapToDto(UrlMapping entity) {
        return UrlResponseDto.builder()
                .shortCode(entity.getShortCode())
                .originalUrl(entity.getOriginalUrl())
                .shortUrl("http://localhost:8080/api/" + entity.getShortCode())
                .clickCount(entity.getClickCount())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}