package com.news.repository;

import com.news.repository.entity.AppConfig;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface AppConfigReactiveRepository extends ReactiveCassandraRepository<AppConfig, Integer> {

}
