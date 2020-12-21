package com.freetimers.spartacus.websocket;

import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.game.GameService;
import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class SpartacusController {
    private final GladiatorCardsRepo gladiatorCardsRepo;
    private final GameService gameService;

    @Autowired
    public SpartacusController(GladiatorCardsRepo gladiatorCardsRepo, GameService gameService) {
        this.gladiatorCardsRepo = gladiatorCardsRepo;
        this.gameService = gameService;
    }

    @MessageMapping("getGladiators")
    public Mono<List<GladiatorCard>> getGladiators() {
        return Mono.just(gladiatorCardsRepo.findAll());
    }

    @MessageMapping("createNewGame")
    public Mono<CoreGameDto> createNewCoreGame() {
        return Mono.just(gameService.createNewCoreGame());
    }
}
