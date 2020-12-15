package com.freetimers.spartacus.game;

import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.gamebox.Deck;
import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.MarketCard;
import com.freetimers.spartacus.gamebox.ReactionCard;
import com.freetimers.spartacus.repository.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GameService {
    private final static int GUARDS_NUMBER = 10; //todo put real number

    private final Logger logger;
    private final GameRepository gameRepository;
    private final EquipmentCardsRepo equipmentCardsRepo;
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final ReactionCardsRepo reactionCardsRepo;
    private final SchemeCardsRepo schemeCardsRepo;
    private final SlaveCardsRepo slaveCardsRepo;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final GameMapper gameMapper;

    @Autowired
    public GameService(Logger logger, GameRepository gameRepository,
                       EquipmentCardsRepo equipmentCardsRepo,
                       GladiatorCardsRepo gladiatorCardsRepo,
                       ReactionCardsRepo reactionCardsRepo,
                       SchemeCardsRepo schemeCardsRepo,
                       SlaveCardsRepo slaveCardsRepo,
                       ApplicationEventPublisher applicationEventPublisher,
                       GameMapper gameMapper) {
        this.logger = logger;
        this.gameRepository = gameRepository;
        this.equipmentCardsRepo = equipmentCardsRepo;
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.reactionCardsRepo = reactionCardsRepo;
        this.schemeCardsRepo = schemeCardsRepo;
        this.slaveCardsRepo = slaveCardsRepo;
        this.applicationEventPublisher = applicationEventPublisher;
        this.gameMapper = gameMapper;
    }

    public CoreGameDto createNewCoreGame() {
        Deck<MarketCard> marketDeck = new Deck<>(Stream.of(
                equipmentCardsRepo.findAll(),
                gladiatorCardsRepo.findAll(),
                slaveCardsRepo.findAll())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        Deck<IntrigueCard> intrigueDeck = new Deck<>(Stream.of(
                reactionCardsRepo.findAll(),
                schemeCardsRepo.findAll())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        Optional<ReactionCard> guardOpt = reactionCardsRepo.findFirstByTitleKey("card.reactionCard.guard.title");
        if (guardOpt.isPresent()) {
            for (int i = 0; i < GUARDS_NUMBER; i++) {
                intrigueDeck.addCard(guardOpt.get());
            }
        } else {
            logger.warn("No guards were added to the game");
        }

        CoreGame newGame = new CoreGame(marketDeck, intrigueDeck);
        newGame.prepareNewGame();
        newGame = gameRepository.save(newGame);
        return gameMapper.gameToGameDto(newGame);
    }
}
