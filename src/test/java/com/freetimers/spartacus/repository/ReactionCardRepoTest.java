package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.ReactionCard;
import com.freetimers.spartacus.gamebox.action.SwitchGladiatorAction;
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

public class ReactionCardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentCardRepoTest.class);

    @Autowired
    private ReactionCardsRepo reactionCardsRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        reactionCardsRepo.deleteAll();
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
    void reactionRepoSaveTest() {
//        given
        Locale.setDefault(Locale.US);
        ReactionCard riggingTheMatch = ReactionCard.of("card.reactionCard.riggingTheMatch.title",
                "card.reactionCard.riggingTheMatch.description", 8, 3,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(SwitchGladiatorAction.getInstance()));

        // when
        ReactionCard riggingTheMatchFromDb = reactionCardsRepo.save(riggingTheMatch);

        // then
        assertEquals(1, reactionCardsRepo.findAll().size());

        assertNotNull(riggingTheMatchFromDb.getId());
        assertEquals("card.reactionCard.riggingTheMatch.title", riggingTheMatchFromDb.getTitleKey());
        assertEquals("Rigging the match", riggingTheMatchFromDb.getTitle());
        assertEquals("card.reactionCard.riggingTheMatch.description", riggingTheMatchFromDb.getDescriptionKey());
        assertEquals("Play after all wagers are final. Change which Gladiator an invited Dominus has chosen", riggingTheMatchFromDb.getDescription());
        assertEquals(8, riggingTheMatchFromDb.getPrice());
        assertEquals(3, riggingTheMatchFromDb.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, riggingTheMatchFromDb.getRequiredInfluenceCondition());
        assertThat(riggingTheMatchFromDb.getAction())
                .hasSize(1)
                .contains(SwitchGladiatorAction.getInstance());
    }

}