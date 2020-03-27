package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
public class NewsFeed {

	@PrimaryKey
	private String location;

	private List<NewsFeedContent> newsFeedContentList;

	public List<NewsFeedContent> getNewsFeedContentList() {
		return newsFeedContentList;
	}

	public void setNewsFeedContentList(List<NewsFeedContent> newsFeedContentList) {
		this.newsFeedContentList = newsFeedContentList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public NewsFeed() {
	}
}
