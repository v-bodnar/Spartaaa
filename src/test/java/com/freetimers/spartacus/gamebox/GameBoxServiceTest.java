package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.SwitchGladiatorAction;
import com.freetimers.spartacus.repository.EquipmentCardRepoTest;
import com.freetimers.spartacus.repository.EquipmentCardsRepo;
import com.freetimers.spartacus.repository.GladiatorCardsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GameBoxServiceTest {

    @Autowired
    public GladiatorCardsRepo gladiatorCardsRepo;

    @Autowired
    public GameBoxService gameBoxService;

    @Autowired
    public EquipmentCardsRepo equipmentCardsRepo;

//    EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title", "card.equipmentCard.armor",
//            1, EquipType.ARMOR);
//            equipmentCardsRepo.save(shield);


    @Test
    public void shieldCardCreatedTest (){

        Locale.setDefault(Locale.US);

        //given
        EquipmentCard shield = EquipmentCard.of("card.equipmentCard.shield.title", "card.equipmentCard.armor",
                1, EquipType.ARMOR);

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
}
