package com.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("com.news")
@EnableAutoConfiguration
@SpringBootApplication
@PropertySource("classpath:application.yml")
@EnableScheduling
public class NewsFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsFeedApplication.class, args);
	}

}
