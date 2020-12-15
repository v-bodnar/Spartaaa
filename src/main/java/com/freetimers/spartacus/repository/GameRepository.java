package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.game.CoreGame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<CoreGame, String> {
}
