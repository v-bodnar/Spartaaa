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
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        //given
        EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title", "card.equipmentCard.shield.description", 1, EquipType.ARMOR);
        EquipmentCard axe = EquipmentCard.of("card.equipmentCard.axe.title", "card.equipmentCard.weapon.axe.title", 1, EquipType.WEAPON);
        EquipmentCard net = EquipmentCard.of("card.equipmentCard.net.title", "card.equipmentCard.special.net.title", 1, EquipType.SPECIAL);

        // when
        equipmentCardsRepo.save(shield);
        equipmentCardsRepo.save(axe);
        equipmentCardsRepo.save(net);

        // then
        assertEquals(3, equipmentCardsRepo.findAll().size());
    }


    @Test
    void equipRepoSaveTest() {
        //given
        Locale.setDefault(Locale.US);
        EquipmentCard axe = EquipmentCard.of("card.equipmentCard.axe.title",
                "card.equipmentCard.axe.description", 2, EquipType.WEAPON);

        EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title",
                "card.equipmentCard.shield.description", 2, EquipType.ARMOR);

        EquipmentCard net = EquipmentCard.of("card.equipmentCard.net.title",
                "card.equipmentCard.net.description", 2, EquipType.SPECIAL);

        //when
        EquipmentCard axeFromDB = equipmentCardsRepo.save(axe);
        EquipmentCard shieldFromDB = equipmentCardsRepo.save(shield);
        EquipmentCard netFromDB = equipmentCardsRepo.save(net);

        //then
        assertEquals(3, equipmentCardsRepo.findAll().size());

        assertNotNull(axeFromDB.getId());
        assertEquals("card.equipmentCard.axe.title", axeFromDB.getTitleKey());
        assertEquals("Axe.", axeFromDB.getTitle());
        assertEquals("card.equipmentCard.axe.description", axeFromDB.getDescriptionKey());
        assertEquals("Exhaust: Deal 1 wound after resolving attack.", axeFromDB.getDescription());
        assertEquals(2, axeFromDB.getPrice());
        assertEquals(EquipType.WEAPON, axeFromDB.getType());

        assertNotNull(shieldFromDB.getId());
        assertEquals("card.equipmentCard.shield.title", shieldFromDB.getTitleKey());
        assertEquals("Shield.", shieldFromDB.getTitle());
        assertEquals("card.equipmentCard.shield.description", shieldFromDB.getDescriptionKey());
        assertEquals("Exhaust: Ignore 1 wound.", shieldFromDB.getDescription());
        assertEquals(2, shieldFromDB.getPrice());
        assertEquals(EquipType.ARMOR, shieldFromDB.getType());

        assertNotNull(netFromDB.getId());
        assertEquals("card.equipmentCard.net.title", netFromDB.getTitleKey());
        assertEquals("Net.", netFromDB.getTitle());
        assertEquals("card.equipmentCard.net.description", netFromDB.getDescriptionKey());
        assertEquals("Exhaust: Win initiative. Use before rolling.", netFromDB.getDescription());
        assertEquals(2, netFromDB.getPrice());
        assertEquals(EquipType.SPECIAL, netFromDB.getType());
    }
}