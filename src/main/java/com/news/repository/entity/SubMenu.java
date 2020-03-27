package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;


@UserDefinedType
public class SubMenu {
    private Integer sequenceNumber;

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    private String displayName;
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    private String keyword;
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    private String webUrl;
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

}
