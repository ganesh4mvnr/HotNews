package com.news.controller;

import com.news.repository.entity.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.news.repository.entity.NewsFeed;
import com.news.service.NewsFeedService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class NewsController {

	Logger logger = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	NewsFeedService newsFeedService;

	@GetMapping("/appConfig/{country}/{state}/{location}")
	Mono<AppConfig> getAppConfig(
			@PathVariable("country") String country,
			@PathVariable("state") String state,
			@PathVariable("location") String location) {
		return newsFeedService.getAppConfig(country,state,location);
	}

	@GetMapping("/primeContent/{category}/{subCategory}")
	Mono<NewsFeed> getNews(@PathVariable("category") String category,@PathVariable("subCategory") String subCategory) {
		return newsFeedService.getNewsByLocation(subCategory);
	}

	//@Scheduled(fixedRate = 5000)
	@GetMapping("/saveNewsFeed")
	public void saveNewsFeed() {
		logger.info("Scheduler");
		 newsFeedService.saveNewsFeed();
	}

}
