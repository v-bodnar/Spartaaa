package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.repository.EquipmentCardsRepo;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})
public class GameBoxServiceTest {

    @Autowired
    public GladiatorCardsRepo gladiatorCardsRepo;

    @Autowired
    public GameBoxService gameBoxService;

    @Autowired
    public EquipmentCardsRepo equipmentCardsRepo;

    @Test
    public void shieldCardCreatedTest() {
        //given
        Locale.setDefault(Locale.US);

        //when
        Optional<EquipmentCard> shieldFromDB = equipmentCardsRepo.findFirstByTitleKey("card.equipmentCard.shield.title");

        //then
        assertTrue(shieldFromDB.isPresent());
        assertNotNull(shieldFromDB.get().getId());
        assertEquals("card.equipmentCard.shield.title", shieldFromDB.get().getTitleKey());
        assertEquals("Shield", shieldFromDB.get().getTitle());
        assertEquals("card.equipmentCard.shield.description", shieldFromDB.get().getDescriptionKey());
        assertEquals("Exhaust: Ignore 1 wound", shieldFromDB.get().getDescription());
        assertEquals(1, shieldFromDB.get().getPrice());
        assertEquals(EquipType.ARMOR, shieldFromDB.get().getType());
    }

    @Test
    public void axeSaveTest() {
        //given
        Locale.setDefault(Locale.US);

        //when
        Optional<EquipmentCard> axeFromDB = equipmentCardsRepo.findFirstByTitleKey("card.equipmentCard.axe.title");

        //then
        assertTrue(axeFromDB.isPresent());
        assertNotNull(axeFromDB.get().getId());
        assertEquals("card.equipmentCard.axe.title", axeFromDB.get().getTitleKey());
        assertEquals("Axe", axeFromDB.get().getTitle());
        assertEquals("card.equipmentCard.axe.description", axeFromDB.get().getDescriptionKey());
        assertEquals("Exhaust: Deal 1 wound after resolving attack", axeFromDB.get().getDescription());
        assertEquals(1, axeFromDB.get().getPrice());
        assertEquals(EquipType.WEAPON, axeFromDB.get().getType());
    }

    @Test
    public void netSaveTest() {
        //given
        Locale.setDefault(Locale.US);

        //when
        Optional<EquipmentCard> netFromDB = equipmentCardsRepo.findFirstByTitleKey("card.equipmentCard.net.title");

        //then
        assertTrue(netFromDB.isPresent());
        assertNotNull(netFromDB.get().getId());
        assertEquals("card.equipmentCard.net.title", netFromDB.get().getTitleKey());
        assertEquals("Net", netFromDB.get().getTitle());
        assertEquals("card.equipmentCard.net.description", netFromDB.get().getDescriptionKey());
        assertEquals("Exhaust: Win initiative. Use before rolling", netFromDB.get().getDescription());
        assertEquals(1, netFromDB.get().getPrice());
        assertEquals(EquipType.SPECIAL, netFromDB.get().getType());
    }
}
