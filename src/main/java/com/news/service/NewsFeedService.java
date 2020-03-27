package com.news.service;

import com.news.repository.AppConfigReactiveRepository;
import com.news.repository.LocationMasterReactiveRepository;
import com.news.repository.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.news.bean.NewsFeedResponse;
import com.news.repository.NewsFeedReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Set;

@Service
@Configuration
public class NewsFeedService {

	Logger logger = LoggerFactory.getLogger(NewsFeedService.class);

	@Autowired
	NewsFeedReactiveRepository newsFeedRepository;
	@Autowired
	AppConfigReactiveRepository appConfigReactiveRepository;
	@Autowired
	LocationMasterReactiveRepository locationMasterReactiveRepository;

	@Value("${newsFeedEndpointURL}")
	private String endPointUrl;

	@Value("${defaultSearchKey}")
	private String defaultSearchKey;

	@Value("${newsFeedapiKey}")
	private String newsFeedapiKey;

	public Mono<AppConfig> getAppConfig(final String  country,final String state,final String location) {
		Mono<AppConfig> appConfigMono = appConfigReactiveRepository.findById(1);
		Mono<LocationMaster> locationMasterMono =
				locationMasterReactiveRepository.findById(new LocationMasterKey(country,state));

		return appConfigMono.flatMap(value-> {

			return locationMasterMono.flatMap(val -> {

				Set<String> keys = val.getLocationMap().keySet();
				List<SubMenu> subMenuList = value.getMainMenu().get(0).getSubMenu();
				if(keys.contains(location)){
					final SubMenu homeCategoryLocal = new SubMenu();
					homeCategoryLocal.setDisplayName("Local");
					homeCategoryLocal.setSequenceNumber(1);
					homeCategoryLocal.setKeyword(location);
					subMenuList.add(homeCategoryLocal);

					final SubMenu homeCategoryCountry = new SubMenu();
					homeCategoryCountry.setDisplayName(country);
					homeCategoryCountry.setSequenceNumber(2);
					homeCategoryCountry.setKeyword(country);
					subMenuList.add(homeCategoryCountry);
				}else if(keys.contains(state)){
					final SubMenu homeCategoryLocal = new SubMenu();
					homeCategoryLocal.setDisplayName("Local");
					homeCategoryLocal.setSequenceNumber(1);
					homeCategoryLocal.setKeyword(state);
					subMenuList.add(homeCategoryLocal);

					final SubMenu homeCategoryCountry = new SubMenu();
					homeCategoryCountry.setDisplayName(country);
					homeCategoryCountry.setSequenceNumber(2);
					homeCategoryCountry.setKeyword(country);
					subMenuList.add(homeCategoryCountry);
				}else if(keys.contains(country)){

					final SubMenu homeCategoryCountry = new SubMenu();
					homeCategoryCountry.setDisplayName(country);
					homeCategoryCountry.setSequenceNumber(1);
					homeCategoryCountry.setKeyword(country);
					subMenuList.add(homeCategoryCountry);
				}
				value.getMainMenu().get(0).setSubMenu(subMenuList);
				return Mono.just(value);
			}
			).switchIfEmpty(Mono.just(value));
		});
	}
	public Mono<NewsFeed> getNewsByLocation(String location) {
		Mono<NewsFeed> newsFeeds = newsFeedRepository.findById(location);
		return newsFeeds;
	}

	public void saveNewsFeed() {
		// Invoke News Feed API
		Mono<NewsFeedResponse> resultMono  = invokeNewsService();
		resultMono.flatMap(obj -> {
			return saveToDB(obj);
		}).subscribeOn(Schedulers.parallel()).subscribe();//complete

	}

	private Mono<Boolean> saveToDB(NewsFeedResponse response) {
		
		return Mono.empty();

	}

	private Mono<NewsFeedResponse> invokeNewsService() {

		WebClient client = WebClient.create(endPointUrl);
		return client.get().uri("?q=" + defaultSearchKey + "&apiKey=" + newsFeedapiKey)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(NewsFeedResponse.class);
	     }

}