package com.freetimers.spartacus.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.dto.DominusBoardDto;
import com.freetimers.spartacus.game.GameMapper;
import com.freetimers.spartacus.game.GameService;
import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.repository.DominusBoardRepo;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class SpartacusController {
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final DominusBoardRepo dominusBoardRepo;
    private final GameService gameService;
    private final GameMapper gameMapper;

    @Autowired
    public SpartacusController(GladiatorCardsRepo gladiatorCardsRepo, DominusBoardRepo dominusBoardRepo, GameService gameService, GameMapper gameMapper) {
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.dominusBoardRepo = dominusBoardRepo;
        this.gameService = gameService;
        this.gameMapper = gameMapper;
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
        return Mono.just(new SerializablePair(gameService.createNewCoreGame(), dominusList));
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
}
