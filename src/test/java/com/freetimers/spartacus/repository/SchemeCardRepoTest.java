package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.SchemeCard;
import com.freetimers.spartacus.gamebox.action.*;
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

public class SchemeCardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(SchemeCardRepoTest.class);

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
                Collections.singletonList(InfluenceForPeoplesAction.getInstance()));
        SchemeCard testOfTheBrotherhood = SchemeCard.of("card.scheme.testOfTheBrotherhood.title",
                "card.scheme.testOfTheBrotherhood.description", 2, 1,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(InfluenceForExhaustGladAction.getinstance()));
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

    @Test
    void setSchemeCardsRepoSaveCardsTest() {
        //given
        Locale.setDefault(Locale.US);
        SchemeCard setHandsToPurpose = SchemeCard.of("card.schemeCard.setHandToPurpose.title",
                "card.schemeCard.setHandToPurpose.description", 2, 4,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(InfluenceForPeoplesAction.getInstance()));
        SchemeCard testOfTheBrotherhood = SchemeCard.of("card.schemeCard.testOfTheBrotherhood.title",
                "card.schemeCard.testOfTheBrotherhood.description", 2, 1,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(InfluenceForExhaustGladAction.getinstance()));
        SchemeCard epicSpectacle = SchemeCard.of("card.schemeCard.epicSpectacle.title",
                "card.schemeCard.epicSpectacle.description", 2, 0,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(InfluenceForReadyGladAction.getInstance()));

        //when
        SchemeCard setHandsToPurposeFromDB = schemeCardsRepo.save(setHandsToPurpose);
        SchemeCard testOfTheBrotherhoodFromDB = schemeCardsRepo.save(testOfTheBrotherhood);
        SchemeCard epicSpectacleFromDB = schemeCardsRepo.save(epicSpectacle);

        //then
        assertEquals(3, schemeCardsRepo.findAll().size());

        assertNotNull(setHandsToPurposeFromDB.getId());
        assertEquals("card.schemeCard.setHandToPurpose.title", setHandsToPurposeFromDB.getTitleKey());
        assertEquals("Set hands to purpose", setHandsToPurposeFromDB.getTitle());
        assertEquals("card.schemeCard.setHandToPurpose.description", setHandsToPurposeFromDB.getDescriptionKey());
        assertEquals("Target Dominus may exhaust any 3 of their slaves, gladiators or guards to gain 1 influence", setHandsToPurposeFromDB.getDescription());
        assertEquals(2, setHandsToPurposeFromDB.getPrice());
        assertEquals(4, setHandsToPurposeFromDB.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, setHandsToPurposeFromDB.getRequiredInfluenceCondition());
        assertThat(setHandsToPurposeFromDB.getActions())
                .hasSize(1)
                .contains(InfluenceForPeoplesAction.getInstance());

        assertNotNull(testOfTheBrotherhoodFromDB.getId());
        assertEquals("card.schemeCard.testOfTheBrotherhood.title", testOfTheBrotherhoodFromDB.getTitleKey());
        assertEquals("Test of the brotherhood", testOfTheBrotherhoodFromDB.getTitle());
        assertEquals("card.schemeCard.testOfTheBrotherhood.description", testOfTheBrotherhoodFromDB.getDescriptionKey());
        assertEquals("Target Dominus gains +1 Influence for every 2 gladiators they exhaust", testOfTheBrotherhoodFromDB.getDescription());
        assertEquals(2, testOfTheBrotherhoodFromDB.getPrice());
        assertEquals(1, testOfTheBrotherhoodFromDB.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, testOfTheBrotherhoodFromDB.getRequiredInfluenceCondition());
        assertThat(testOfTheBrotherhoodFromDB.getActions())
                .hasSize(1)
                .contains(InfluenceForExhaustGladAction.getinstance());

        assertNotNull(epicSpectacleFromDB.getId());
        assertEquals("card.schemeCard.epicSpectacle.title", epicSpectacleFromDB.getTitleKey());
        assertEquals("Epic spectacle", epicSpectacleFromDB.getTitle());
        assertEquals("card.schemeCard.epicSpectacle.description", epicSpectacleFromDB.getDescriptionKey());
        assertEquals("+2 influence to target Dominus with at least 5 ready Gladiators", epicSpectacleFromDB.getDescription());
        assertEquals(2, epicSpectacleFromDB.getPrice());
        assertEquals(0, epicSpectacleFromDB.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, epicSpectacleFromDB.getRequiredInfluenceCondition());
        assertThat(epicSpectacleFromDB.getActions())
                .hasSize(1)
                .contains(InfluenceForReadyGladAction.getInstance());
    }
}

