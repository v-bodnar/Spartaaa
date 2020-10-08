package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.model.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface TestRepository extends MongoRepository<TestEntity, String> {

}