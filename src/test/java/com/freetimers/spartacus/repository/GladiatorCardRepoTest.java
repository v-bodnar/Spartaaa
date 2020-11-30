package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.gamebox.action.InfluenceForExhaustGladAction;
import com.freetimers.spartacus.gamebox.action.StartingGladiators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestExecution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})

public class GladiatorCardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(GladiatorCardRepoTest.class);

    @Autowired
    private GladiatorCardsRepo gladiatorCardsRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        gladiatorCardsRepo.deleteAll();
    }

    @AfterTestExecution
    public void cleanUp() throws IOException {
        LOG.info("Removing test db from {}", testDbPath);
        Path testDb = Paths.get(testDbPath);
        if (Files.deleteIfExists(testDb)) {
            LOG.info("Clean up success!");
        } else {
            LOG.info("Clean up failure!");
        }
    }

    @Test
    void gladiatorRepoCreateTest() {
        //given
        GladiatorCard syrrianWarrior = GladiatorCard.of("card.gladiator.syrianWarrior.title",
                "card.gladiator.syrianWarrior.description", 2, 2, 2, 3, true,
                Collections.singletonList(StartingGladiators.getInstance()));
        GladiatorCard thracianWarrior = GladiatorCard.of("card.gladiator.thracianWarrior.title",
                "card.gladiator.thracianWarrior.description", 2, 3, 2, 2, true,
                Collections.singletonList(StartingGladiators.getInstance()));
        GladiatorCard numidianWarrior = GladiatorCard.of("card.gladiator.numidianWarrior.title",
                "card.gladiator.numidianWarrior.description", 2, 3, 1, 3, true,
                Collections.singletonList(StartingGladiators.getInstance()));

        // when
        gladiatorCardsRepo.save(syrrianWarrior);
        gladiatorCardsRepo.save(thracianWarrior);
        gladiatorCardsRepo.save(numidianWarrior);

        // then
        assertEquals(3, gladiatorCardsRepo.findAll().size());
    }

    @Test
    void gladiatorSaveTest() {
        //given
        Locale.setDefault(Locale.US);

        GladiatorCard syrianWarrior = GladiatorCard.of("card.gladiatorCard.syrianWarrior.title",
                "card.gladiatorCard.syrianWarrior.description", 2, 2, 2, 3, true,
                Collections.singletonList(StartingGladiators.getInstance()));

        GladiatorCard thracianWarrior = GladiatorCard.of("card.gladiatorCard.thracianWarrior.title",
                "card.gladiatorCard.thracianWarrior.description", 2, 3, 2, 2, true,
                Collections.singletonList(StartingGladiators.getInstance()));

        GladiatorCard numidianWarrior = GladiatorCard.of("card.gladiatorCard.numidianWarrior.title",
                "card.gladiatorCard.numidianWarrior.description", 2, 3, 1, 3, true,
                Collections.singletonList(StartingGladiators.getInstance()));

        //when
        GladiatorCard syrianWarriorFromDB = gladiatorCardsRepo.save(syrianWarrior);
        GladiatorCard thracianWarriorFromDB = gladiatorCardsRepo.save(thracianWarrior);
        GladiatorCard numidianWarriorFromDB = gladiatorCardsRepo.save(numidianWarrior);

        //then
        assertNotNull(syrianWarriorFromDB.getId());
        assertEquals("card.gladiatorCard.syrianWarrior.title", syrianWarriorFromDB.getTitleKey());
        assertEquals("Syrian warrior.", syrianWarriorFromDB.getTitle());
        assertEquals("card.gladiatorCard.syrianWarrior.description", syrianWarriorFromDB.getDescriptionKey());
        assertEquals("Starting Gladiator.", syrianWarriorFromDB.getDescription());
        assertEquals(2, syrianWarriorFromDB.getPrice());
        assertEquals(2, syrianWarriorFromDB.getAttack());
        assertEquals(2, syrianWarriorFromDB.getDefence());
        assertEquals(3, syrianWarriorFromDB.getSpeed());
        assertEquals(true, syrianWarriorFromDB.isStarting());
        assertThat(syrianWarriorFromDB.getActions())
                .hasSize(1)
                .contains(StartingGladiators.getInstance());

        assertNotNull(thracianWarriorFromDB.getId());
        assertEquals("card.gladiatorCard.thracianWarrior.title", thracianWarriorFromDB.getTitleKey());
        assertEquals("Thracian warrior.", thracianWarriorFromDB.getTitle());
        assertEquals("card.gladiatorCard.thracianWarrior.description", thracianWarriorFromDB.getDescriptionKey());
        assertEquals("Starting Gladiator.", thracianWarriorFromDB.getDescription());
        assertEquals(2, thracianWarriorFromDB.getPrice());
        assertEquals(3, thracianWarriorFromDB.getAttack());
        assertEquals(2, thracianWarriorFromDB.getDefence());
        assertEquals(2, thracianWarriorFromDB.getSpeed());
        assertEquals(true, thracianWarriorFromDB.isStarting());
        assertThat(thracianWarriorFromDB.getActions())
                .hasSize(1)
                .contains(StartingGladiators.getInstance());

        assertNotNull(numidianWarriorFromDB.getId());
        assertEquals("card.gladiatorCard.numidianWarrior.title", numidianWarriorFromDB.getTitleKey());
        assertEquals("Numidian warrior.", numidianWarriorFromDB.getTitle());
        assertEquals("card.gladiatorCard.numidianWarrior.description", numidianWarriorFromDB.getDescriptionKey());
        assertEquals("Starting Gladiator.", numidianWarriorFromDB.getDescription());
        assertEquals(2, numidianWarriorFromDB.getPrice());
        assertEquals(3, numidianWarriorFromDB.getAttack());
        assertEquals(1, numidianWarriorFromDB.getDefence());
        assertEquals(3, numidianWarriorFromDB.getSpeed());
        assertEquals(true, numidianWarriorFromDB.isStarting());
        assertThat(numidianWarriorFromDB.getActions())
                .hasSize(1)
                .contains(StartingGladiators.getInstance());
    }
}
