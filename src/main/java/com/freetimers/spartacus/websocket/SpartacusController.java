package com.freetimers.spartacus.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.dto.DominusBoardDto;
import com.freetimers.spartacus.game.GameMapper;
import com.freetimers.spartacus.game.GameService;
import com.freetimers.spartacus.game.event.GameEvent;
import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.repository.DominusBoardRepo;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SpartacusController {
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final DominusBoardRepo dominusBoardRepo;
    private final GameService gameService;
    private final GameMapper gameMapper;
    private final Logger logger;
    private final SessionService sessionService;
    private final Flux<GameEvent> gameEventPublisher;

    @Autowired
    public SpartacusController(GladiatorCardsRepo gladiatorCardsRepo, DominusBoardRepo dominusBoardRepo,
                               GameService gameService, GameMapper gameMapper, Logger logger, SessionService sessionService) {
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.dominusBoardRepo = dominusBoardRepo;
        this.gameService = gameService;
        this.gameMapper = gameMapper;
        this.logger = logger;
        this.sessionService = sessionService;
        this.gameEventPublisher = Flux.fr
    }

    @MessageMapping("getGladiators")
    public Mono<List<GladiatorCard>> getGladiators() {
        return Mono.just(gladiatorCardsRepo.findAll());
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
    public Mono<Void> selectDominus(RSocketRequester requester, String gameId, String dominusBoardId, String playersName) {
        Optional<Session> sessionOpt = sessionService.getSessionByRequester(requester);

        if (sessionOpt.isPresent()) {
            gameService.selectDominus(gameId, dominusBoardId, playersName, sessionOpt.get().getId());
            return Mono.empty();
        } else {
            return Mono.error(new Exception("Session not found"));
        }

    }

    private class SerializablePair {
        @JsonProperty
        private final CoreGameDto key;
        @JsonProperty
        private final List<DominusBoardDto> value;

        public SerializablePair(@JsonProperty CoreGameDto key, @JsonProperty List<DominusBoardDto> value) {
            this.key = key;
            this.value = value;
        }

        public CoreGameDto getKey() {
            return key;
        }

        public List<DominusBoardDto> getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SerializablePair that = (SerializablePair) o;
            return Objects.equals(key, that.key) &&
                    Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
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

    public Flux<GameEvent> subscribeGameEvents(){
        return
    }

}
