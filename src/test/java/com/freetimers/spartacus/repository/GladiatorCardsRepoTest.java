package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.GladiatorCard;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})

public class GladiatorCardsRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(GladiatorCardsRepoTest.class);

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
    void schemeRepoCreateTest() {
        //given
        GladiatorCard syrrianWarrior = GladiatorCard.of("card.gladiator.syrianWarrior.title",
                "card.gladiator.syrianWarrior.description", 2, 2, 2, 3, true);
        GladiatorCard thracianWarrior = GladiatorCard.of("card.gladiator.thracianWarrior.title",
                "card.gladiator.thracianWarrior.description", 2, 3, 2, 2, true);
        GladiatorCard numidianWarrior = GladiatorCard.of("card.gladiator.numidianWarrior.title",
                "card.gladiator.numidianWarrior.description", 2, 3, 1, 3, true);

        // when
        gladiatorCardsRepo.save(syrrianWarrior);
        gladiatorCardsRepo.save(thracianWarrior);
        gladiatorCardsRepo.save(numidianWarrior);

        // then
        assertEquals(3, gladiatorCardsRepo.findAll().size());
    }

}
