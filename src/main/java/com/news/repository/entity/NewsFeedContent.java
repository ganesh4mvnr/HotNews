package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class NewsFeedContent {

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	private Integer sequenceNumber;
	private String contentType;
	private String sourceName;
	private String sourceLogoUrl;
	private String sourceURL;
	private String title;
	private String content;
	private String contentImageURL;
	private String contentVideoURL;
	private String timeStamp;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceLogoUrl() {
		return sourceLogoUrl;
	}

	public void setSourceLogoUrl(String sourceLogoUrl) {
		this.sourceLogoUrl = sourceLogoUrl;
	}

	public String getSourceURL() {
		return sourceURL;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentImageURL() {
		return contentImageURL;
	}

	public void setContentImageURL(String contentImageURL) {
		this.contentImageURL = contentImageURL;
	}

	public String getContentVideoURL() {
		return contentVideoURL;
	}

	public void setContentVideoURL(String contentVideoURL) {
		this.contentVideoURL = contentVideoURL;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public NewsFeedContent() {
	}
}
