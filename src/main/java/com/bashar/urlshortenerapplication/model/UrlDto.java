package com.bashar.urlshortenerapplication.model;

public class UrlDto {

	private String url;
	private String expirationDate; // optional

	public UrlDto() {
	}

	public UrlDto(String url, String expirationDate) {
		this.url = url;
		this.expirationDate = expirationDate;
	}

	public String getUrl() {
		return url;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "UrlDto [url=" + url + ", expirationDate=" + expirationDate + "]";
	}

}
