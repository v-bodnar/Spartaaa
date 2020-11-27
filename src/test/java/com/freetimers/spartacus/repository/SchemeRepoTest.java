package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Scheme;
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

public class SchemeRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentRepoTest.class);

    @Autowired
    private SchemeRepo schemeRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        schemeRepo.deleteAll();
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
        Scheme setHandsToPurpose = Scheme.of("card.scheme.setHandToPurpose.title",
                "card.scheme.setHandToPurpose.description", 2, 4,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
        Scheme testOfTheBrotherhood = Scheme.of("card.scheme.testOfTheBrotherhood.title",
                "card.scheme.testOfTheBrotherhood.description", 2, 1,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
        Scheme epicSpectacle = Scheme.of("card.scheme.epicSpectacle.title",
                "card.scheme.epicSpectacle.description", 2, 0,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);

        // when
        schemeRepo.save(setHandsToPurpose);
        schemeRepo.save(testOfTheBrotherhood);
        schemeRepo.save(epicSpectacle);

        // then
        assertEquals(3, schemeRepo.findAll().size());
    }

}

