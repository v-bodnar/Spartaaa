package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReactionRepo extends MongoRepository<Reaction, String> {
}