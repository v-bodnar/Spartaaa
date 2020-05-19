package com.freetimers.spartaa.repository;

import com.freetimers.spartaa.model.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface TestRepository extends MongoRepository<TestEntity, String> {

}