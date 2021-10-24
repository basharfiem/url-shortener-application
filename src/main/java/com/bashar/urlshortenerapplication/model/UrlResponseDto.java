package com.bashar.urlshortenerapplication.model;

public class UrlResponseDto {

	private String originalUrl;
	private String shortUrl;

	public UrlResponseDto() {
	}

	public UrlResponseDto(String originalUrl, String shortUrl) {
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	@Override
	public String toString() {
		return "UrlResponseDto [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + "]";
	}

}
