package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.ReactionCard;
import com.freetimers.spartacus.gamebox.action.ActionFactory;
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
        //given
        Locale.setDefault(Locale.US);
        ReactionCard riggingTheMatch = ReactionCard.of("card.reactionCard.riggingTheMatch.title",
                "card.reactionCard.riggingTheMatch.description", 2, 0,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(ActionFactory.SWITCH_GLADIATOR));

        ReactionCard supportFromRome = ReactionCard.of("card.reactionCard.supportFromRome.title",
                "card.reactionCard.supportFromRome.description", 3, 8,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(ActionFactory.FAIL_SCHEME));

        ReactionCard aShamefulLudus = ReactionCard.of("card.reactionCard.aShamefulLudus.title",
                "card.reactionCard.aShamefulLudus.description", 2, 0,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(ActionFactory.DECREASE_INFLUENCE_GLAD));


        // when
        ReactionCard riggingTheMatchFromDb = reactionCardsRepo.save(riggingTheMatch);
        ReactionCard supportFromRomeFromDB = reactionCardsRepo.save(supportFromRome);
        ReactionCard aShamefulLudusFromDB = reactionCardsRepo.save(aShamefulLudus);

        // then
        assertEquals(3, reactionCardsRepo.findAll().size());

        assertNotNull(riggingTheMatchFromDb.getId());
        assertEquals("card.reactionCard.riggingTheMatch.title", riggingTheMatchFromDb.getTitleKey());
        assertEquals("Rigging the match", riggingTheMatchFromDb.getTitle());
        assertEquals("card.reactionCard.riggingTheMatch.description", riggingTheMatchFromDb.getDescriptionKey());
        assertEquals("Play after all wagers are final. Change which Gladiator an invited Dominus has chosen", riggingTheMatchFromDb.getDescription());
        assertEquals(2, riggingTheMatchFromDb.getPrice());
        assertEquals(0, riggingTheMatchFromDb.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, riggingTheMatchFromDb.getRequiredInfluenceCondition());
        assertThat(riggingTheMatchFromDb.getActions())
                .hasSize(1)
                .contains(ActionFactory.SWITCH_GLADIATOR);

        assertNotNull(supportFromRomeFromDB.getId());
        assertEquals("card.reactionCard.supportFromRome.title", supportFromRomeFromDB.getTitleKey());
        assertEquals("Support from Rome", supportFromRomeFromDB.getTitle());
        assertEquals("card.reactionCard.supportFromRome.description", supportFromRomeFromDB.getDescriptionKey());
        assertEquals("Foil a Scheme. You may retrieve a Guard card from the discard pile", supportFromRomeFromDB.getDescription());
        assertEquals(3, supportFromRomeFromDB.getPrice());
        assertEquals(8, supportFromRomeFromDB.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, supportFromRomeFromDB.getRequiredInfluenceCondition());
        assertThat(supportFromRomeFromDB.getActions())
                .hasSize(1)
                .contains(ActionFactory.FAIL_SCHEME);

        assertNotNull(aShamefulLudusFromDB.getId());
        assertEquals("card.reactionCard.aShamefulLudus.title", aShamefulLudusFromDB.getTitleKey());
        assertEquals("A shameful ludus", aShamefulLudusFromDB.getTitle());
        assertEquals("card.reactionCard.aShamefulLudus.description", aShamefulLudusFromDB.getDescriptionKey());
        assertEquals("-1 Influence to target Dominus with no ready Gladiators. May not be played in the Arena Phase", aShamefulLudusFromDB.getDescription());
        assertEquals(2, aShamefulLudusFromDB.getPrice());
        assertEquals(0, aShamefulLudusFromDB.getRequiredInfluence());
        assertEquals(IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL, aShamefulLudusFromDB.getRequiredInfluenceCondition());
        assertThat(aShamefulLudusFromDB.getActions())
                .hasSize(1)
                .contains(ActionFactory.DECREASE_INFLUENCE_GLAD);
   }
//
}