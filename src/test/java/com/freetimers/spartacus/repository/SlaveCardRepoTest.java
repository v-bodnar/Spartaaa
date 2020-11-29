package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.SlaveCard;
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
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})
public class SlaveCardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentCardRepoTest.class);

    @Autowired
    private SlaveCardsRepo slaveCardsRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        slaveCardsRepo.deleteAll();
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
        SlaveCard debtor = SlaveCard.of("card.slave.debtor.title", "card.slave.debtor.description",
                2, 1, 1, 1, new ArrayList<>());
        SlaveCard attendant = SlaveCard.of("card.slave.attendant.title", "card.slave.attendant.description",
                2, 1, 1, 1, new ArrayList<>());
        SlaveCard convict = SlaveCard.of("card.slave.convict.title", "card.slave.convict.description",
                2, 1, 1, 1, new ArrayList<>());

        // when
        slaveCardsRepo.save(debtor);
        slaveCardsRepo.save(attendant);
        slaveCardsRepo.save(convict);

        // then
        assertEquals(3, slaveCardsRepo.findAll().size());
    }

}
