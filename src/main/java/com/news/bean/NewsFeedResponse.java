package com.news.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.news.bean.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsFeedResponse {
	
	private String status;
	private String totalResults;
	private List<Article> articles;

}
