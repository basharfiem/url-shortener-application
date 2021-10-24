package com.bashar.urlshortenerapplication.service;

import com.bashar.urlshortenerapplication.model.Url;
import com.bashar.urlshortenerapplication.model.UrlDto;

import antlr.collections.List;

public interface UrlService {
	
	public Url generateShorLink(UrlDto urldto);
	public Url persistShorLink(Url url);
	
	public Url getEncodedLink(String url);
	public void deleteShortLink(Url url);
	
	public java.util.List<Url> getAllExistingUrl();
}
