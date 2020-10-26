package com.freetimers.spartacus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TestEntity {

    @Id
    private final String id;

    public TestEntity(String id) {
        this.id = id;
    }

    public static TestEntity of(){
        return new TestEntity(null);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TestEntity.id = " + id;
    }
}