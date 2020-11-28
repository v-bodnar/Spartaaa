package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.ReactionCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReactionCardsRepo extends MongoRepository<ReactionCard, String> {
}