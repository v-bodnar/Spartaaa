package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.EquipType;
import com.freetimers.spartacus.gamebox.EquipmentCard;
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

public class EquipmentCardRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentCardRepoTest.class);

    @Autowired
    private EquipmentCardsRepo equipmentCardsRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        equipmentCardsRepo.deleteAll();
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
    void equipRepoCreateTest() {
//        //given
        EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title", "card.equipmentCard.armor", 1, EquipType.ARMOR);
        EquipmentCard ax = EquipmentCard.of("card.equipmentCard.ax.title", "card.equipmentCard.weapon.title", 1, EquipType.WEAPON);
        EquipmentCard net = EquipmentCard.of("card.equipmentCard.net.title", "card.equipmentCard.special.title", 1, EquipType.SPECIAL);

        // when
        equipmentCardsRepo.save(shield);
        equipmentCardsRepo.save(ax);
        equipmentCardsRepo.save(net);

        // then
        assertEquals(3, equipmentCardsRepo.findAll().size());
    }

}
