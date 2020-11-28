package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.SlaveCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlaveCardsRepo extends MongoRepository<SlaveCard, String> {
    Optional<SlaveCard> findFirstByTitle(String title);
}
