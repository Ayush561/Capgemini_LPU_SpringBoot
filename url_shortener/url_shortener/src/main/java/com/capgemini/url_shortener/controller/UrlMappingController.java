package com.capgemini.url_shortener.controller;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.url_shortener.dto.StatsDto;
import com.capgemini.url_shortener.dto.UrlRequestDto;
import com.capgemini.url_shortener.dto.UrlResponseDto;
import com.capgemini.url_shortener.service.UrlMappingService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlMappingController {

    private final UrlMappingService service;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> create(@Valid @RequestBody UrlRequestDto request) {
        UrlResponseDto response = service.createShortUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {
        String url = service.resolveAndIncrement(shortCode);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<StatsDto> stats(@PathVariable String shortCode) {
        return ResponseEntity.ok(service.getStats(shortCode));
    }

    @GetMapping("/urls")
    public ResponseEntity<Page<UrlResponseDto>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(service.getAll(page, size));
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Void> delete(@PathVariable String shortCode) {
        service.delete(shortCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<UrlResponseDto>> top() {
        return ResponseEntity.ok(service.getTop5());
    }
}
