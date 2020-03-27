package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Map;

@Table
public class NewsSourceMaster {

	@PrimaryKey private String location;
	private List<SourceDetails> sourceList;

	public List<SourceDetails> getSourceList() {
		return sourceList;
	}

	public void setSourceList(List<SourceDetails> sourceList) {
		this.sourceList = sourceList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
