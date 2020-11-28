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

    @Test
    public void setUpUSTest() {
        //given
        Locale.setDefault(Locale.US);
        //when
        Optional<GladiatorCard> syrianWarrior = gladiatorCardsRepo.findFirstByTitle("card.syrianWarrior.title");
        assertTrue(syrianWarrior.isPresent());
        String syrianWarriorTitle = syrianWarrior.get().getTitleKey();

        //then
        assertEquals("Syrian warrior", syrianWarriorTitle);
    }

    @Test
    public void setUpRUTest() {
        //given
        Locale.setDefault(new Locale("ru"));
        //when
        Optional<GladiatorCard> syrianWarrior = gladiatorCardsRepo.findFirstByTitle("card.syrianWarrior.title");
        assertTrue(syrianWarrior.isPresent());
        String syrianWarriorTitle = syrianWarrior.get().getTitleKey();

        //then
        assertEquals("Сирийский воин", syrianWarriorTitle);
    }
}
