package com.freetimers.spartacus.websocket;

import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class SpartacusController {
    private final GladiatorCardsRepo gladiatorCardsRepo;

    public SpartacusController(GladiatorCardsRepo gladiatorCardsRepo) {
        this.gladiatorCardsRepo = gladiatorCardsRepo;
    }

    @MessageMapping("getGladiators")
    public Mono<List<GladiatorCard>> getGladiators() {
        return Mono.just(gladiatorCardsRepo.findAll());
    }
}
