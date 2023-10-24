package com.kelvin.urlshortenerapi.common;

import java.time.LocalDateTime;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "url")
public class Url{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String originalUrl;
    @Column(nullable = false)
    private String shortUrl;

    @Column(nullable = false)
    private String customAlias; //ver como vou utilizar isso

    @Column(nullable = false)
    private LocalDateTime operationTime; // Tempo da operação em milissegundos // long ou Date? fica a questão.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public void setCustomAlias(String customAlias) {
        this.customAlias = customAlias;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }
}



