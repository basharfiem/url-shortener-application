package com.bashar.urlshortenerapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bashar.urlshortenerapplication.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{

	public Url findByshortLink(String shortLink);
}
