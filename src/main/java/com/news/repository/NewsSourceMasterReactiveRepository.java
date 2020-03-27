package com.news.repository;

import com.news.repository.entity.NewsSourceMaster;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface NewsSourceMasterReactiveRepository extends ReactiveCassandraRepository<NewsSourceMaster, String> {

}
