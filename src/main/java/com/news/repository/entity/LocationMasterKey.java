package com.news.repository.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
@PrimaryKeyClass
public class LocationMasterKey implements Serializable {

    @PrimaryKeyColumn(name = "country",type = PrimaryKeyType.PARTITIONED)
    private String country;

    @PrimaryKeyColumn(name = "state",ordinal = 0)
    private String state;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocationMasterKey(final String country, final String state) {
        this.country = country;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationMasterKey locationMasterKey = (LocationMasterKey) o;

        if (country != null ? !country.equals(locationMasterKey.country) : locationMasterKey.country != null)
            return false;
        return state != null? state.equals(locationMasterKey.state) : locationMasterKey.state==null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
