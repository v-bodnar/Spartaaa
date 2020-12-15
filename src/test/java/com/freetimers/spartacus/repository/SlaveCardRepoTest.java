package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.SlaveCard;
import org.assertj.core.api.Assertions;
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
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void SlaveRepoCreateTest() {
        //given
        SlaveCard debtor = SlaveCard.of("card.slave.debtor.title", "card.slave.debtor.description",
                2, 1, 1, 1, true, new ArrayList<>());
        SlaveCard attendant = SlaveCard.of("card.slave.attendant.title", "card.slave.attendant.description",
                2, 1, 1, 1, true, new ArrayList<>());
        SlaveCard convict = SlaveCard.of("card.slave.convict.title", "card.slave.convict.description",
                2, 1, 1, 1, true, new ArrayList<>());

        // when
        slaveCardsRepo.save(debtor);
        slaveCardsRepo.save(attendant);
        slaveCardsRepo.save(convict);

        // then
        assertEquals(3, slaveCardsRepo.findAll().size());
    }

    @Test
    void slaveRepoSaveTest() {
        //given
        Locale.setDefault(Locale.US);

        SlaveCard debtor = SlaveCard.of("card.slaveCard.debtor.title", "card.slaveCard.debtor.description",
                2, 1, 1, 1, true, Collections.emptyList());

        SlaveCard attendant = SlaveCard.of("card.slaveCard.attendant.title", "card.slaveCard.attendant.description",
                2, 1, 1, 1, true, Collections.emptyList());

        SlaveCard convict = SlaveCard.of("card.slaveCard.convict.title", "card.slaveCard.convict.description",
                2, 1, 1, 1, true, Collections.emptyList());

        //when
        SlaveCard debtorFromDB = slaveCardsRepo.save(debtor);
        SlaveCard attendantFromDB = slaveCardsRepo.save(attendant);
        SlaveCard convictFromDB = slaveCardsRepo.save(convict);

        //
        assertNotNull(debtorFromDB.getId());
        assertEquals("card.slaveCard.debtor.title", debtorFromDB.getTitleKey());
        assertEquals("Debtor", debtorFromDB.getTitle());
        assertEquals("card.slaveCard.debtor.description", debtorFromDB.getDescriptionKey());
        assertEquals("Starting Slave", debtorFromDB.getDescription());
        assertEquals(2, debtorFromDB.getPrice());
        assertEquals(1, debtorFromDB.getAttack());
        assertEquals(1, debtorFromDB.getDefence());
        assertEquals(1, debtorFromDB.getSpeed());
        assertEquals(true, debtorFromDB.isStarting());

        assertNotNull(attendantFromDB.getId());
        assertEquals("card.slaveCard.attendant.title", attendantFromDB.getTitleKey());
        assertEquals("Attendant", attendantFromDB.getTitle());
        assertEquals("card.slaveCard.attendant.description", attendantFromDB.getDescriptionKey());
        assertEquals("Starting Slave", attendantFromDB.getDescription());
        assertEquals(2, attendantFromDB.getPrice());
        assertEquals(1, attendantFromDB.getAttack());
        assertEquals(1, attendantFromDB.getDefence());
        assertEquals(1, attendantFromDB.getSpeed());
        assertEquals(true, attendantFromDB.isStarting());

        assertNotNull(convictFromDB.getId());
        assertEquals("card.slaveCard.convict.title", convictFromDB.getTitleKey());
        assertEquals("Convict", convictFromDB.getTitle());
        assertEquals("card.slaveCard.convict.description", convictFromDB.getDescriptionKey());
        assertEquals("Starting Slave", convictFromDB.getDescription());
        assertEquals(2, convictFromDB.getPrice());
        assertEquals(1, convictFromDB.getAttack());
        assertEquals(1, convictFromDB.getDefence());
        assertEquals(1, convictFromDB.getSpeed());
        assertEquals(true, convictFromDB.isStarting());
    }

}