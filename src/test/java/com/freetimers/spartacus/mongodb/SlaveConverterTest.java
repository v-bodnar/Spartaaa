//package com.freetimers.spartacus.mongodb;
//
//import com.freetimers.spartacus.gamebox.Slave;
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
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//
//public class SlaveConverterTest {
//
//    @Mock
//    private TranslationService translationService;
//
//    @Test
//    public void slaveConverterSuccessfulTest() {
//        //Given
//        Locale.setDefault(Locale.US);
//
//        SlaveConverter slaveConverter = new SlaveConverter(translationService);
//
//        when(translationService.translate("card.slave.debtor.title")).thenReturn("Debtor");
//        when(translationService.translate("card.slave.startingSlave")).thenReturn("Starting Slave");
//
//        ObjectId id = new ObjectId(new Date());
//        Document document = new Document();
//        document.put("_id", id);
//        document.put("titleKey", "card.slave.debtor.title");
//        document.put("descriptionKey", "card.slave.startingSlave");
//        document.put("price", 2);
//        document.put("attack", 1);
//        document.put("defence", 1);
//        document.put("speed", 1);
//
//        Slave expectedSlave = new Slave(id.toHexString(), "card.slave.debtor.title", "Debtor",
//                "card.slave.startingSlave", "Starting Slave", 2, 1, 1, 1);
//
//        //When
//        Slave convertedSlave = slaveConverter.convert(document);
//
//        //Then
//        assertEquals(expectedSlave, convertedSlave);
//    }
//
//}
