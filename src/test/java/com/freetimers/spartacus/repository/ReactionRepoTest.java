package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Reaction;
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

public class ReactionRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentRepoTest.class);

    @Autowired
    private ReactionRepo reactionRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        reactionRepo.deleteAll();
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
    void reactionRepoCreateTest() {
        //given
        Reaction supportFromRome = Reaction.of("card.reaction.supportFromRome.title",
                "card.reaction.supportFromRome.description", 8, 3,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
        Reaction riggingTheMatch = Reaction.of("card.reaction.riggingTheMatch.title",
                "card.reaction.riggingTheMatch.description", 8, 3,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);
        Reaction aShamefulLudus = Reaction.of("card.reaction.aShamefulLudus.title",
                "card.reaction.aShamefulLudus.description", 8, 3,
                IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);

        // when
        reactionRepo.save(supportFromRome);
        reactionRepo.save(riggingTheMatch);
        reactionRepo.save(aShamefulLudus);

        // then
        assertEquals(3, reactionRepo.findAll().size());
    }

}