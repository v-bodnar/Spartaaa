package com.freetimers.spartaa.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TestEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public TestEntity setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "TestEntity.id = " + id;
    }
}