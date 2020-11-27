package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.EquipmentCard;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Locale;

import static com.freetimers.spartacus.gamebox.EquipType.ARMOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class EquipConverterTest {
    @Mock
    private TranslationService translationService;

    @Test
    public void converterSuccessfuTest() {
        //Given
        Locale.setDefault(Locale.US);

        EquipConverter equipConverter = new EquipConverter(translationService);

        when(translationService.translate("card.equip.shield.title")).thenReturn("Shield");
        when(translationService.translate("card.equip.armor")).thenReturn("Exhaust: Ignore 1 wound");

        ObjectId id = new ObjectId(new Date());
        Document document = new Document();
        document.put("_id", id);
        document.put("titleKey", "card.equip.shield.title");
        document.put("descriptionKey", "card.equip.armor");
        document.put("price", 1);
        document.put("type", ARMOR);

//        EquipmentCard equipExpected = new EquipmentCard(id.toHexString(), "card.equip.shield.title", "Shield",
//                "card.equip.armor", "Exhaust: Ignore 1 wound", 1, ARMOR, );

        //When
        EquipmentCard convertedEquip = equipConverter.convert(document);

        //Then
//        assertEquals(equipExpected, convertedEquip);

    }


}
