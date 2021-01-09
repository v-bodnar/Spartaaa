package com.freetimers.spartacus.websocket;

import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.dto.DominusBoardDto;
import com.freetimers.spartacus.dto.GameEventDto;
import com.freetimers.spartacus.dto.SelectDominusDto;
import com.freetimers.spartacus.game.GameMapper;
import com.freetimers.spartacus.game.GameService;
import com.freetimers.spartacus.game.event.GameEvent;
import com.freetimers.spartacus.repository.DominusBoardRepo;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Controller
public class SpartacusController {
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final DominusBoardRepo dominusBoardRepo;
    private final GameService gameService;
    private final GameMapper gameMapper;
    private final Logger logger;
    private final SessionService sessionService;
    private final Flux<GameEventDto> gameEventPublisher;

    @Autowired
    public SpartacusController(GladiatorCardsRepo gladiatorCardsRepo, DominusBoardRepo dominusBoardRepo,
                               GameService gameService, GameMapper gameMapper, Logger logger, SessionService sessionService,
                               EventBridge eventBridge) {
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.dominusBoardRepo = dominusBoardRepo;
        this.gameService = gameService;
        this.gameMapper = gameMapper;
        this.logger = logger;
        this.sessionService = sessionService;
        this.gameEventPublisher = Flux.create(eventBridge).share();
    }

    @ConnectMapping
    void handleConnection(RSocketRequester requester) {
        requester.rsocket()
                .onClose()
                .doFirst(() -> {
                    Session session = sessionService.createSession(requester);
                    logger.info("Client: {} CONNECTED.", session.getId());
                })
                .doOnError(error -> {
                    logger.warn("Channel to client CLOSED");
                })
                .doFinally(consumer -> {
                    Optional<Session> sessionOpt = sessionService.getSessionByRequester(requester);
                    sessionOpt.ifPresent(session -> session.setRequester(null));
                    logger.info("Client {} DISCONNECTED", sessionOpt.map(Session::getId).orElse(""));
                })
                .subscribe();
    }

    @MessageMapping("createNewGame")
    public Mono<SerializablePair> createNewCoreGame() {

        List<DominusBoardDto> dominusList = dominusBoardRepo.findAll().stream()
                .map(gameMapper::dominusBoardToDominusBoardDto)
                .collect(Collectors.toList());
        CoreGameDto coreGameDto = gameMapper.gameToGameDto(gameService.createNewCoreGame());
        return Mono.just(new SerializablePair(coreGameDto, dominusList));
    }

    @MessageMapping("selectDominus")
    public Mono<Void> selectDominus(RSocketRequester requester, SelectDominusDto selectDominusDto) {
        Optional<Session> sessionOpt = sessionService.getSessionByRequester(requester);

        if (sessionOpt.isPresent()) {
            gameService.selectDominus(selectDominusDto.getGameId(), selectDominusDto.getDominusBoardId(), selectDominusDto.getPlayersName(), sessionOpt.get().getId());
            return Mono.empty();
        } else {
            return Mono.error(new Exception("Session not found"));
        }

    }

    @MessageMapping("subscribeForGameEvents")
    public Flux<GameEventDto> subscribeForGameEvents(RSocketRequester requester) {
        Optional<Session> sessionOpt = sessionService.getSessionByRequester(requester);
        logger.debug("New subscription for game events from: {}", sessionOpt.map(Session::getId).orElse("null"));
        return gameEventPublisher;
    }

}
