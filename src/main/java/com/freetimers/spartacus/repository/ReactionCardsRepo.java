package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.gamebox.ReactionCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReactionCardsRepo extends MongoRepository<ReactionCard, String> {
    Optional<ReactionCard> findFirstByTitleKey(String titleKey);

    List<ReactionCard> findAllByTitleKey(String titleKey);
}