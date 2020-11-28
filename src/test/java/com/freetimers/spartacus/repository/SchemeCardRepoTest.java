package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.SchemeCard;
import com.freetimers.spartacus.gamebox.action.DecreaseInInfluenceAction;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})

public class SchemeCardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentCardRepoTest.class);

    @Autowired
    private SchemeCardsRepo schemeCardsRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        schemeCardsRepo.deleteAll();
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
        SchemeCard setHandsToPurpose = SchemeCard.of("card.scheme.setHandToPurpose.title",
                "card.scheme.setHandToPurpose.description", 2, 4,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(DecreaseInInfluenceAction.getInstance()));
        SchemeCard testOfTheBrotherhood = SchemeCard.of("card.scheme.testOfTheBrotherhood.title",
                "card.scheme.testOfTheBrotherhood.description", 2, 1,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(DecreaseInInfluenceAction.getInstance()));
        SchemeCard epicSpectacle = SchemeCard.of("card.scheme.epicSpectacle.title",
                "card.scheme.epicSpectacle.description", 2, 0,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(DecreaseInInfluenceAction.getInstance()));

        // when
        schemeCardsRepo.save(setHandsToPurpose);
        schemeCardsRepo.save(testOfTheBrotherhood);
        schemeCardsRepo.save(epicSpectacle);

        // then
        assertEquals(3, schemeCardsRepo.findAll().size());
    }

}

