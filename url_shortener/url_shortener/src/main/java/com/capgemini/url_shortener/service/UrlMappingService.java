package com.capgemini.url_shortener.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.url_shortener.dto.StatsDto;
import com.capgemini.url_shortener.dto.UrlRequestDto;
import com.capgemini.url_shortener.dto.UrlResponseDto;

public interface UrlMappingService {

    UrlResponseDto createShortUrl(UrlRequestDto request);

    String resolveAndIncrement(String shortCode);

    StatsDto getStats(String shortCode);

    Page<UrlResponseDto> getAll(int page, int size);

    void delete(String shortCode);

    List<UrlResponseDto> getTop5();
}
