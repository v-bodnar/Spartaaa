package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GameBoxServiceTest {

    @Autowired
    public GladiatorCardsRepo gladiatorCardsRepo;

    @Autowired
    public GameBoxService gameBoxService;
}
