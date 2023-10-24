package com.kelvin.urlshortenerapi.controller;

import com.kelvin.urlshortenerapi.dto.UrlRequest;
import com.kelvin.urlshortenerapi.service.UrlService;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;


@RestController
@RequestMapping("/api/v1")

public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @ApiOperation(value = "Convert new url", notes = "Converts long url to short url")
    @PostMapping("Create-short")
    public String convertToShortUrl(@RequestBody UrlRequest request) {
        return urlService.convertToShortUrl(request);
    }

    @ApiOperation(value = "Redirect", notes = "Finds original url from short url and redirects")
    @GetMapping(value = "{shortUrl}")
    @Cacheable(value = "urls", key = "#shortUrl", sync = true)
    public ResponseEntity<void> getAndRedirect(@PathVariable String shortUrl){
        var url = urlService.getOriUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }

    }





