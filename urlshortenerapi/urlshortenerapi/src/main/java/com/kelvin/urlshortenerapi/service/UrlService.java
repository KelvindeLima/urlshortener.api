package com.kelvin.urlshortenerapi.service;

import com.kelvin.urlshortenerapi.common.Url;
import com.kelvin.urlshortenerapi.dto.UrlRequest;
import com.kelvin.urlshortenerapi.repository.UrlRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private BaseConversion conversion;

    public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(UrlRequest request) {
        var url = new Url();
        url.setOriginalUrl(request.getOriginalUrl());
        url.setOperationTime(request.getOperationTime());
        var entity = urlRepository.save(url);
        return conversion.encode(entity.getId());

    }

    public String getOriUrl(String shortUrl){
        var id = conversion.decode(shortUrl);
        var entity = urlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no entity with" + shortUrl));

        return entity.getOriginalUrl();
    }


}

