package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.GameBoxService;
import com.freetimers.spartacus.gamebox.Gladiator;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "spring.mongodb.embedded.storage.databaseDir=${user.home}/Freetimers/spartacus/testDB"
})
@EnableAutoConfiguration(exclude= GameBoxService.class)
public class GladiatorConverterTest {
    @Autowired
    public GladiatorConverter gladiatorConverter;

    @Test
    public void converterSuccessfulTest() {
        //Given
        Locale.setDefault(Locale.US);

        Document document = new Document();
        document.put("_id", new ObjectId(new Date()));
        document.put("titleKey", "card.gladiator.syrianWarrior.title");
        document.put("descriptionKey", "card.gladiator.startingGladiator");
        document.put("price", 2);
        document.put("attack", 3);
        document.put("defence", 2);
        document.put("speed", 2);

        Gladiator expectedGladiator = new Gladiator("_id", "card.gladiator.syrianWarrior.title",
                "Syrian warrior", "card.gladiator.startingGladiator", "Starting gladiator",
                2, 3, 2, 2);

        //When
        Gladiator convertedGladiator = gladiatorConverter.convert(document);

        //Then
        assertEquals(expectedGladiator, convertedGladiator);
    }
}
