package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Map;

@Table
public class LocationMaster {

	@PrimaryKey private LocationMasterKey key;

    private Map<String,String> locationMap;

	public LocationMasterKey getKey() {
		return key;
	}

	public void setKey(LocationMasterKey key) {
		this.key = key;
	}

	public Map<String, String> getLocationMap() {
		return locationMap;
	}

	public void setLocationMap(Map<String, String> locationMap) {
		this.locationMap = locationMap;
	}

	public LocationMaster(final LocationMasterKey key) {
		this.key=key;
	}
}
