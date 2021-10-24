package com.bashar.urlshortenerapplication.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bashar.urlshortenerapplication.model.Url;
import com.bashar.urlshortenerapplication.model.UrlDto;
import com.bashar.urlshortenerapplication.repository.UrlRepository;
import com.google.common.hash.Hashing;

@Component
public class UrlServiceImpl implements UrlService{

	 private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);
	@Autowired
	UrlRepository urlRepository;
	
	@Override
	public Url generateShorLink(UrlDto urldto) {
		if(StringUtils.isNotEmpty(urldto.getUrl()))
		{
			String encodedUrl = encodedUrl(urldto.getUrl());
			
			Url urlToPersist = new Url();
			urlToPersist.setCreatedDate(LocalDateTime.now());
			urlToPersist.setOriginalUrl(urldto.getUrl());
			urlToPersist.setShortLink(encodedUrl);

			Url urlToRet = persistShorLink(urlToPersist);
			
			if(urlToRet != null)
					return urlToRet;
			return null;
		}
		return null;
	}

	private String encodedUrl(String url) {
		String encodedUrl = "";
		LocalDateTime time = LocalDateTime.now();
		encodedUrl = Hashing.murmur3_32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
		return encodedUrl;
	}

	@Override
	public Url persistShorLink(Url url) {
		
		return urlRepository.save(url);
	}

	@Override
	public Url getEncodedLink(String url) {
		Url urlToRet = urlRepository.findByshortLink(url);
		return urlToRet;
	}

	@Override
	public void deleteShortLink(Url url) {
		
		urlRepository.delete(url);
	}

	@Override
	public java.util.List<Url> getAllExistingUrl() {

		java.util.List<Url> urlList = urlRepository.findAll();

		if (urlList != null)
			return urlList;
		return null;
	}

}
