package com.news.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import com.news.repository.entity.NewsFeed;

public interface NewsFeedReactiveRepository extends ReactiveCassandraRepository<NewsFeed, String> {

}
