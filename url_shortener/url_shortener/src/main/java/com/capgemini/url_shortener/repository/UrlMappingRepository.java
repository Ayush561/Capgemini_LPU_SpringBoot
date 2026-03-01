package com.capgemini.url_shortener.repository;


import com.capgemini.url_shortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    Optional<UrlMapping> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);

    List<UrlMapping> findByCreatedAtAfter(LocalDateTime date);

    @Query("SELECT u FROM UrlMapping u ORDER BY u.clickCount DESC LIMIT 5")
    List<UrlMapping> findTop5ByClickCountDesc();
}
