package com.freetimers.spartacus.websocket;

import com.freetimers.spartacus.gamebox.Gladiator;
import com.freetimers.spartacus.repository.GladiatorRepo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class SpartacusController {
    private final GladiatorRepo gladiatorRepo;

    public SpartacusController(GladiatorRepo gladiatorRepo) {
        this.gladiatorRepo = gladiatorRepo;
    }

    @MessageMapping("getGladiators")
    public Mono<List<Gladiator>> getGladiators() {
        return Mono.just(gladiatorRepo.findAll());
    }
}
