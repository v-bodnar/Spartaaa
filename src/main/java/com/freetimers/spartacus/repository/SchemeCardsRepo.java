package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.SchemeCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeCardsRepo extends MongoRepository<SchemeCard, String> {
}
