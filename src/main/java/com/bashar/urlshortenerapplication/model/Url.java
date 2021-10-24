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
	
	
	public Url() {
	}
	public Url(long id, String originalUrl, String shortLink, LocalDateTime createdDate) {
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.createdDate = createdDate;
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
	
	@Override
	public String toString() {
		return "Url [id=" + id + ", originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", createdDate="
				+ createdDate + "]";
	}
	
	
	
}
