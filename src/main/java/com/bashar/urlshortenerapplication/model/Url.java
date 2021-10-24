package com.bashar.urlshortenerapplication.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Url {

	@Id
	@GeneratedValue
	private long id;
	@Lob
	private String originalUrl;
	private String shortLink;
	private LocalDateTime createdDate;
	private LocalDateTime expirationDate;
	
	
	public Url() {
	}
	public Url(long id, String originalUrl, String shortLink, LocalDateTime createdDate, LocalDateTime expirationDate) {
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.createdDate = createdDate;
		this.expirationDate = expirationDate;
	}
	public long getId() {
		return id;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public String getShortLink() {
		return shortLink;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", createdDate="
				+ createdDate + ", expirationDate=" + expirationDate + "]";
	}
	
	
	
}
