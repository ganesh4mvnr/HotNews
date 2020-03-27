package com.news.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Article {
	
	private Source source;
	private String author;
	private String title;
	private String description;
	private String url;
	private String urlToImage;
	private String publishedAt;
	private String content;

}
