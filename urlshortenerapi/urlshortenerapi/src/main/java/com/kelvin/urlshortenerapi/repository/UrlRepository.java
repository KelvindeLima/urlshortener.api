package com.kelvin.urlshortenerapi.repository;

import com.kelvin.urlshortenerapi.common.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface UrlRepository extends JpaRepository<Url, Long>{
}
