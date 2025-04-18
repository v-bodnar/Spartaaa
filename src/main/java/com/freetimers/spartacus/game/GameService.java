package com.freetimers.spartacus.game;

import com.freetimers.spartacus.game.event.DominusSelectedEvent;
import com.freetimers.spartacus.game.event.GameStartedEvent;
import com.freetimers.spartacus.game.event.PlayerJoinedEvent;
import com.freetimers.spartacus.gamebox.*;
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
    private final Logger logger;
    private final GameRepository gameRepository;
    private final EquipmentCardsRepo equipmentCardsRepo;
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final ReactionCardsRepo reactionCardsRepo;
    private final SchemeCardsRepo schemeCardsRepo;
    private final SlaveCardsRepo slaveCardsRepo;
    private final DominusBoardRepo dominusBoardRepo;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public GameService(Logger logger,
                       GameRepository gameRepository,
                       EquipmentCardsRepo equipmentCardsRepo,
                       GladiatorCardsRepo gladiatorCardsRepo,
                       ReactionCardsRepo reactionCardsRepo,
                       SchemeCardsRepo schemeCardsRepo,
                       SlaveCardsRepo slaveCardsRepo,
                       DominusBoardRepo dominusBoardRepo,
                       ApplicationEventPublisher applicationEventPublisher) {
        this.logger = logger;
        this.gameRepository = gameRepository;
        this.equipmentCardsRepo = equipmentCardsRepo;
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.reactionCardsRepo = reactionCardsRepo;
        this.schemeCardsRepo = schemeCardsRepo;
        this.slaveCardsRepo = slaveCardsRepo;
        this.dominusBoardRepo = dominusBoardRepo;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public CoreGame createNewCoreGame() {
        logger.info("Creating new game");
        Deck<MarketCard> marketDeck = new Deck<>(Stream.of(
                equipmentCardsRepo.findAll(),
                gladiatorCardsRepo.findAll(),
                slaveCardsRepo.findAll())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
        marketDeck.shuffle();

        Deck<IntrigueCard> intrigueDeck = new Deck<>(Stream.of(
                reactionCardsRepo.findAll(),
                schemeCardsRepo.findAll())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
        intrigueDeck.shuffle();

        CoreGame newGame = new CoreGame(marketDeck, intrigueDeck);
        newGame.prepareNewGame();
        newGame = gameRepository.save(newGame);
        return newGame;
    }

    public synchronized void selectDominus(String gameId, String dominusBoardId, String playersName, String sessionId, boolean gameOwner) {
        logger.info("GameId: %s Player: %s Session %s Selected Dominus: %s", gameId, playersName, sessionId, dominusBoardId);
        Optional<CoreGame> coreGameOpt = gameRepository.findById(gameId);
        CoreGame coreGame = coreGameOpt.orElseThrow();

        Optional<DominusBoard> dominusBoardOpt = dominusBoardRepo.findById(dominusBoardId);
        DominusBoard dominusBoard = dominusBoardOpt.orElseThrow();

        coreGame.selectDominus(dominusBoard, playersName, sessionId, gameOwner);

        coreGame = gameRepository.save(coreGame);

        applicationEventPublisher.publishEvent(new DominusSelectedEvent(this, coreGame));
    }

    public synchronized void startTheGame(String gameId) {
        logger.info("Starting the game: %s", gameId);
        Optional<CoreGame> coreGameOpt = gameRepository.findById(gameId);
        CoreGame coreGame = coreGameOpt.orElseThrow();
        coreGame.startGame();
        gameRepository.save(coreGame);

        applicationEventPublisher.publishEvent(new GameStartedEvent(this, coreGame));
    }

    public synchronized Optional<CoreGame> joinGame(String playerName, String gameId, String password, String sessionId) {
        Optional<CoreGame> gameOpt = gameRepository.findById(gameId);
        if (gameOpt.isPresent() && gameOpt.get().getPassword().equals(password)) {
            CoreGame coreGame = gameOpt.get();
            if(!coreGame.getGamePhase().equals(Phase.LOBBY)){
                coreGame.resetPlayersSessionId(playerName, sessionId);
            }
            applicationEventPublisher.publishEvent(new PlayerJoinedEvent(this, coreGame));
            return gameOpt;
        } else {
            return Optional.empty();
        }
    }

}
