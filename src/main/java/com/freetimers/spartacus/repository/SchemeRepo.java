package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Scheme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeRepo extends MongoRepository<Scheme, String> {
}
