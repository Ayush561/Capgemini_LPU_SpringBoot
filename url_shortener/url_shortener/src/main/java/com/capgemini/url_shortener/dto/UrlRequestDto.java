package com.capgemini.url_shortener.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlRequestDto {

    @NotBlank(message = "Original URL must not be blank")
    private String originalUrl;

    private String customAlias;
}