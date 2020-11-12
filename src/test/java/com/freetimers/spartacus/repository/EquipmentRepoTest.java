package com.freetimers.spartacus.repository;

import com.freetimers.spartacus.gamebox.Equip;
import com.freetimers.spartacus.gamebox.EquipType;
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

public class EquipmentRepoTest {
    private static final Logger LOG = LoggerFactory.getLogger(EquipmentRepoTest.class);

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Value("spring.mongodb.embedded.storage.databaseDir")
    private String testDbPath;

    @BeforeEach
    public void cleanUpDb() {
        equipmentRepo.deleteAll();
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
        //given
        Equip shield = Equip.of("card.equip.shield.title", "card.equip.armor", 1, EquipType.ARMOR);
        Equip ax = Equip.of("card.equip.ax.title", "card.equip.weapon.title", 1, EquipType.WEAPON);
        Equip net = Equip.of("card.equip.net.title", "card.equip.special.title", 1, EquipType.SPECIAL);

        // when
        equipmentRepo.save(shield);
        equipmentRepo.save(ax);
        equipmentRepo.save(net);

        // then
        assertEquals(3, equipmentRepo.findAll().size());
    }

}
