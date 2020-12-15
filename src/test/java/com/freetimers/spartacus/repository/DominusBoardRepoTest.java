package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.DominusBoard;
import org.junit.jupiter.api.Assertions;
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
import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})

public class DominusBoardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(DominusBoardRepoTest.class);

    @Autowired
    private DominusBoardRepo dominusBoardRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        dominusBoardRepo.deleteAll();
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
    void dominusBoardCreateTest(){
        //given
        Locale.setDefault(Locale.US);

        DominusBoard Batiatus = DominusBoard.of("card.dominusBoard.batiatus.title",
                "card.dominusBoard.batiatus.description", 10,
                3, 1, 2);

        DominusBoard Glaber = DominusBoard.of("card.dominusBoard.glaber.title",
                "card.dominusBoard.glaber.description", 10,
                1, 2, 3);

        DominusBoard Tullius = DominusBoard.of("card.dominusBoard.tullius.title",
                "card.dominusBoard.tullius.description",
                9,2, 3, 1);

        DominusBoard Solonius = DominusBoard.of("card.dominusBoard.solonius.title",
                "card.dominusBoard.solonius.description",
                12,2, 2, 1);

        //when
        dominusBoardRepo.save(Batiatus);
        dominusBoardRepo.save(Glaber);
        dominusBoardRepo.save(Tullius);
        dominusBoardRepo.save(Solonius);

        //then
        Assertions.assertEquals(4,dominusBoardRepo.findAll().size());
    }

    @Test
    void dominusBoardSaveRepoTest (){
        //given
        DominusBoard Batiatus = DominusBoard.of("card.dominusBoard.batiatus.title",
                "card.dominusBoard.batiatus.description", 10,
                3, 1, 2);

        DominusBoard Glaber = DominusBoard.of("card.dominusBoard.glaber.title",
                "card.dominusBoard.glaber.description", 10,
                1, 2, 3);

        DominusBoard Tullius = DominusBoard.of("card.dominusBoard.tullius.title",
                "card.dominusBoard.tullius.description",
                9,2, 3, 1);

        DominusBoard Solonius = DominusBoard.of("card.dominusBoard.solonius.title",
                "card.dominusBoard.solonius.description",
                12,2, 2, 1);

        //when
        DominusBoard BatiatusFromDB = dominusBoardRepo.save(Batiatus);
        DominusBoard GlaberFromDB = dominusBoardRepo.save(Glaber);
        DominusBoard TulliusFromDB = dominusBoardRepo.save(Tullius);
        DominusBoard SoloniusFromDB = dominusBoardRepo.save(Solonius);

        //then
        assertNotNull(BatiatusFromDB.getId());

        assertEquals("card.dominusBoard.batiatus.title", BatiatusFromDB.getTitleKey());
        assertEquals(Optional.of("BATIATUS"), BatiatusFromDB.getTitle());
        assertEquals("card.dominusBoard.batiatus.description", BatiatusFromDB.getDescriptionKey());
        assertEquals(Optional.of("Exhibition match: Exhaust 2 Gladiators to gain 2 gold. Fodder for the primus: " +
                "Discard 3 Gladiators to gain +1 Influence"), BatiatusFromDB.getDescription());
        assertEquals(10 , BatiatusFromDB.getStartingGold());
        assertEquals(3, BatiatusFromDB.getStartingGladiators());
        assertEquals(1, BatiatusFromDB.getStartingSlaves());
        assertEquals(2, BatiatusFromDB.getStartingGuards());

        assertEquals("card.dominusBoard.glaber.title", GlaberFromDB.getTitleKey());
        assertEquals(Optional.of("GLABER"), GlaberFromDB.getTitle());
        assertEquals("card.dominusBoard.glaber.description", GlaberFromDB.getDescriptionKey());
        assertEquals(Optional.of("Legionnaire patrol: Exhaust 3 Guards, draw +1 Intrigue card." +
                " Dispatch to Rome: Discard 3 Guards to gain + 1 Influence"), GlaberFromDB.getDescription());
        assertEquals(10 , GlaberFromDB.getStartingGold());
        assertEquals(1, GlaberFromDB.getStartingGladiators());
        assertEquals(2, GlaberFromDB.getStartingSlaves());
        assertEquals(3, GlaberFromDB.getStartingGuards());

        assertEquals("card.dominusBoard.tullius.title", TulliusFromDB.getTitleKey());
        assertEquals(Optional.of("TULLIUS"), TulliusFromDB.getTitle());
        assertEquals("card.dominusBoard.tullius.description", TulliusFromDB.getDescriptionKey());
        assertEquals(Optional.of("Duplicitous dealings: Exhaust 3 Slaves, discard up to 3 cards, replace with" +
                " new cards. To the mines: Discard 3 Slaves to gain +1 Influence"), TulliusFromDB.getDescription());
        assertEquals(9 , TulliusFromDB.getStartingGold());
        assertEquals(2, TulliusFromDB.getStartingGladiators());
        assertEquals(3, TulliusFromDB.getStartingSlaves());
        assertEquals(1, TulliusFromDB.getStartingGuards());

        assertEquals("card.dominusBoard.solonius.title", SoloniusFromDB.getTitleKey());
        assertEquals(Optional.of("SOLONIUS"), SoloniusFromDB.getTitle());
        assertEquals("card.dominusBoard.solonius.description", SoloniusFromDB.getDescriptionKey());
        assertEquals(Optional.of("Bribes and pandering: Pay X gold to reduce any Scheme`s required Influence" +
                " by X. A finger in every  pie: Discard 1 Gladiator, 1 Slave and 1 Guard to gain +1 Influence"),
                SoloniusFromDB.getDescription());
        assertEquals(12 , SoloniusFromDB.getStartingGold());
        assertEquals(2, SoloniusFromDB.getStartingGladiators());
        assertEquals(2, SoloniusFromDB.getStartingSlaves());
        assertEquals(1, SoloniusFromDB.getStartingGuards());
    }
}
