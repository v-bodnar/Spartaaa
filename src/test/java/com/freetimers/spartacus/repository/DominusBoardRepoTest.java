//package com.freetimers.spartacus.repository;
//
//import com.freetimers.spartacus.gamebox.DominusBoard;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.event.annotation.AfterTestExecution;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Locale;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
//
//@SpringBootTest(properties = {
//        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
//})
//
//public class DominusBoardRepoTest {
//    private static final Logger LOG = LoggerFactory.getLogger(DominusBoardRepoTest.class);
//
//    @Autowired
//    private DominusBoardRepo dominusBoardRepo;
//
//    @Value("spring.mongodb.embedded.storage.databaseDir")
//    private String testDbPath;
//
//    @BeforeEach
//    public void cleanUpDb() {
//        dominusBoardRepo.deleteAll();
//    }
//
//    @AfterTestExecution
//    public void cleanUp() throws IOException {
//        LOG.info("Removing test db from {}", testDbPath);
//        Path testDb = Paths.get(testDbPath);
//        if (Files.deleteIfExists(testDb)) {
//            LOG.info("Clean up success!");
//        } else {
//            LOG.info("Clean up failure!");
//        }
//    }
//
//    @Test
//    void dominusBoardCreateTest(){
//        //given
//        Locale.setDefault(Locale.US);
//
//        DominusBoard Batiatus = DominusBoard.of("card.dominusBoard.batiatus.title",
//                "card.dominusBoard.batiatus.description", 10,
//                3, 1, 2);
//
//        DominusBoard Glaber = DominusBoard.of("card.dominusBoard.glaber.title",
//                "card.dominusBoard.glaber.description", 10,
//                1, 2, 3);
//
//        DominusBoard Tullius = DominusBoard.of("card.dominusBoard.tullius.title",
//                "card.dominusBoard.tullius.description",
//                9,2, 3, 1);
//
//        DominusBoard Solonius = DominusBoard.of("card.dominusBoard.solonius.title",
//                "card.dominusBoard.solonius.description",
//                12,2, 2, 1);
//
//        //when
//        dominusBoardRepo.save(Batiatus);
//        dominusBoardRepo.save(Glaber);
//        dominusBoardRepo.save(Tullius);
//        dominusBoardRepo.save(Solonius);
//
//        //then
//        Assertions.assertEquals(4,dominusBoardRepo.findAll().size());
//    }
//
//    @Test
//    void dominusBoardSaveRepoTest (){
//        //given
//        DominusBoard Batiatus = DominusBoard.of("card.dominusBoard.batiatus.title",
//                "card.dominusBoard.batiatus.description", 10,
//                3, 1, 2);
//
//        DominusBoard Glaber = DominusBoard.of("card.dominusBoard.glaber.title",
//                "card.dominusBoard.glaber.description", 10,
//                1, 2, 3);
//
//        DominusBoard Tullius = DominusBoard.of("card.dominusBoard.tullius.title",
//                "card.dominusBoard.tullius.description",
//                9,2, 3, 1);
//
//        DominusBoard Solonius = DominusBoard.of("card.dominusBoard.solonius.title",
//                "card.dominusBoard.solonius.description",
//                12,2, 2, 1);
//
//        //when
//        DominusBoard BatiatusFromDB = dominusBoardRepo.save(Batiatus);
//        DominusBoard GlaberFromDB = dominusBoardRepo.save(Glaber);
//        DominusBoard TulliusFromDB = dominusBoardRepo.save(Tullius);
//        DominusBoard SoloniusFromDB = dominusBoardRepo.save(Solonius);
//
//        //then
//        assertNotNull(BatiatusFromDB.getId());
//
//        Assertions.assertEquals("card.dominusBoard.batiatus.title", BatiatusFromDB.getTitleKey());
//        Assertions.assertEquals("BATIATUS", BatiatusFromDB.getTitle());
//        Assertions.assertEquals("card.dominusBoard.batiatus.description", BatiatusFromDB.getDescriptionKey());
//        Assertions.assertEquals("Exhibition match: Exhaust 2 Gladiators to gain 2 gold. Fodder for the primus: " +
//                "Discard 3 Gladiators to gain +1 Influence.", BatiatusFromDB.getDescription());
//        Assertions.assertEquals(10 , BatiatusFromDB.getStartingGold());
//        Assertions.assertEquals(3, BatiatusFromDB.getStartingGladiators());
//        Assertions.assertEquals(1, BatiatusFromDB.getStartingSlaves());
//        Assertions.assertEquals(2, BatiatusFromDB.getStartingGuards());
//
//        Assertions.assertEquals("card.dominusBoard.glaber.title", GlaberFromDB.getTitleKey());
//        Assertions.assertEquals("GLABER", GlaberFromDB.getTitle());
//        Assertions.assertEquals("card.dominusBoard.glaber.description", GlaberFromDB.getDescriptionKey());
//        Assertions.assertEquals("Legionnaire patrol: Exhaust 3 Guards, draw +1 Intrigue card." +
//                " Dispatch to Rome: Discard 3 Guards to gain + 1 Influence.", GlaberFromDB.getDescription());
//        Assertions.assertEquals(10 , GlaberFromDB.getStartingGold());
//        Assertions.assertEquals(1, GlaberFromDB.getStartingGladiators());
//        Assertions.assertEquals(2, GlaberFromDB.getStartingSlaves());
//        Assertions.assertEquals(3, GlaberFromDB.getStartingGuards());
//
//        Assertions.assertEquals("card.dominusBoard.tullius.title", TulliusFromDB.getTitleKey());
//        Assertions.assertEquals("TULLIUS", TulliusFromDB.getTitle());
//        Assertions.assertEquals("card.dominusBoard.tullius.description", TulliusFromDB.getDescriptionKey());
//        Assertions.assertEquals("Duplicitous dealings: Exhaust 3 Slaves, discard up to 3 cards, replace with" +
//                " new cards. To the mines: Discard 3 Slaves to gain +1 Influence.", TulliusFromDB.getDescription());
//        Assertions.assertEquals(9 , TulliusFromDB.getStartingGold());
//        Assertions.assertEquals(2, TulliusFromDB.getStartingGladiators());
//        Assertions.assertEquals(3, TulliusFromDB.getStartingSlaves());
//        Assertions.assertEquals(1, TulliusFromDB.getStartingGuards());
//
//        Assertions.assertEquals("card.dominusBoard.solonius.title", SoloniusFromDB.getTitleKey());
//        Assertions.assertEquals("SOLONIUS", SoloniusFromDB.getTitle());
//        Assertions.assertEquals("card.dominusBoard.solonius.description", SoloniusFromDB.getDescriptionKey());
//        Assertions.assertEquals("Bribes and pandering: Pay X gold to reduce any Scheme`s required Influence" +
//                " by X. A finger in every  pie: Discard 1 Gladiator, 1 Slave and 1 Guard to gain +1 Influence.",
//                SoloniusFromDB.getDescription());
//        Assertions.assertEquals(12 , SoloniusFromDB.getStartingGold());
//        Assertions.assertEquals(2, SoloniusFromDB.getStartingGladiators());
//        Assertions.assertEquals(2, SoloniusFromDB.getStartingSlaves());
//        Assertions.assertEquals(1, SoloniusFromDB.getStartingGuards());
//    }
//}
