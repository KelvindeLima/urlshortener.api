package com.kelvin.urlshortenerapi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

//TODO:
@ApiModel(description =  "Request object for Post method")
public class UrlRequest {
    @ApiModelProperty(required = true, notes ="Url to convert to short")
    private String originalUrl;

    @ApiModelProperty(notes = "Operation Time of Url") //
    private long operationTime;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public long getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(long operationTime) {
        this.operationTime = operationTime;
    }
}
