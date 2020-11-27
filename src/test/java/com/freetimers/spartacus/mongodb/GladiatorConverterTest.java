//package com.freetimers.spartacus.mongodb;
//
//import com.freetimers.spartacus.gamebox.Gladiator;
//import org.bson.Document;
//import org.bson.types.ObjectId;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Date;
//import java.util.Locale;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//
//public class GladiatorConverterTest {
//
//    @Mock
//    private TranslationService translationService;
//
//    @Test
//    public void converterSuccessfulTest() {
//        //Given
//        Locale.setDefault(Locale.US);
//
////        GladiatorConverter gladiatorConverter = new GladiatorConverter(translationService);
//
//        when(translationService.translate("card.gladiator.syrianWarrior.title")).thenReturn("Syrian warrior");
//        when(translationService.translate("card.gladiator.startingGladiator")).thenReturn("Starting Gladiator");
//
//        ObjectId id = new ObjectId(new Date());
//        Document document = new Document();
//        document.put("_id", id);
//        document.put("titleKey", "card.gladiator.syrianWarrior.title");
//        document.put("descriptionKey", "card.gladiator.startingGladiator");
//        document.put("price", 2);
//        document.put("attack", 3);
//        document.put("defence", 2);
//        document.put("speed", 2);
//
//        Gladiator expectedGladiator = new Gladiator(id.toHexString(), "card.gladiator.syrianWarrior.title",
//                "Syrian warrior", "card.gladiator.startingGladiator", "Starting Gladiator",
//                2, 3, 2, 2);
//
//        //When
//        Gladiator convertedGladiator = gladiatorConverter.convert(document);
//
//        //Then
//        assertEquals(expectedGladiator, convertedGladiator);
//    }
//
//    @Test
//    public void converterFailedTest() {
//        //Given
//        GladiatorConverter gladiatorConverter = new GladiatorConverter(translationService);
//        Document document = new Document();
//
//        //When
//        assertThrows(NullPointerException.class, () ->
//                gladiatorConverter.convert(document));
//
//    }
//}
