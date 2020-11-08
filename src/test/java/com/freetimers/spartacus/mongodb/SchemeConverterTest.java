package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Scheme;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class SchemeConverterTest {

    @Mock
    private TranslationService translationService;

    @Test
    public void converterSuccessfulTest() {
        //Given
        Locale.setDefault(Locale.US);

        SchemeConverter schemeConverter = new SchemeConverter(translationService);

        when(translationService.translate("card.scheme.setHandToPurpose.title"))
                .thenReturn("Set hands to purpose");
        when(translationService.translate("card.scheme.setHandToPurpose.description"))
                .thenReturn("Target Dominus may exhaust any 3 of their slaves, gladiators or guards to gain 1 influence");

        ObjectId id = new ObjectId(new Date());
        Document document = new Document();
        document.put("_id", id);
        document.put("titleKey", "card.scheme.setHandToPurpose.title");
        document.put("descriptionKey", "card.scheme.setHandToPurpose.description");
        document.put("price", 2);
        document.put("requiredInfluence", 4);
        document.put("requiredInfluenceCondition", IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);

        Scheme schemeExpected = new Scheme(id.toHexString(), "card.scheme.setHandToPurpose.title",
                "Set hands to purpose", "card.scheme.setHandToPurpose.description",
                "Target Dominus may exhaust any 3 of their slaves, gladiators or guards to gain 1 influence",
                2, 4, IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL);

        //when
        Scheme convertedScheme = schemeConverter.convert(document);

        //then
        assertEquals(schemeExpected, convertedScheme);
    }
}
