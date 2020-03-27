package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;


@UserDefinedType
public class SourceDetails {
    private Integer sequenceNumber;
    private String sourceName;
    private String sourcelogo;

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourcelogo() {
        return sourcelogo;
    }

    public void setSourcelogo(String sourcelogo) {
        this.sourcelogo = sourcelogo;
    }
}
