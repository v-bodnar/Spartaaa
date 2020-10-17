package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Gladiator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GladiatorsRepo extends MongoRepository<Gladiator, String> {
}
