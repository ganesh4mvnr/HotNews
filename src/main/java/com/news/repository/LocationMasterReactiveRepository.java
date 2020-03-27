package com.news.repository;

import com.news.repository.entity.LocationMaster;
import com.news.repository.entity.LocationMasterKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface LocationMasterReactiveRepository extends ReactiveCassandraRepository<LocationMaster, LocationMasterKey> {

}
