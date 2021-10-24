package com.bashar.urlshortenerapplication.model;

import java.time.LocalDateTime;

public class UrlResponseDto {

	private String originalUrl;
	private String shortUrl;
	private LocalDateTime expirationDate;
	
	
	public UrlResponseDto() {
	}

	public UrlResponseDto(String originalUrl, String shortUrl, LocalDateTime expirationDate) {
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.expirationDate = expirationDate;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "UrlResponseDto [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", expirationDate="
				+ expirationDate + "]";
	}
	
	
	
}
