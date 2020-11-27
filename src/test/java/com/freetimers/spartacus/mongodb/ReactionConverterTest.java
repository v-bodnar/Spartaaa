package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Reaction;
import com.freetimers.spartacus.gamebox.action.SwitchGladiatorAction;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ReactionConverterTest {

    @Mock
    private TranslationService translationService;

    @Test
    public void converterSuccessfulTest() {
        //Given
        Locale.setDefault(Locale.US);

        ReactionConverter reactionConverter = new ReactionConverter(translationService);

        when(translationService.translate("card.reaction.supportFromRome.title"))
                .thenReturn("Support from Rome.");
        when(translationService.translate("card.reaction.supportFromRome.description"))
                .thenReturn("Foil a Scheme. You may retrive a Guard card from the discrad pile.");

        ObjectId id = new ObjectId(new Date());
        Document document = new Document();
        document.put("_id", id);
        document.put("titleKey", "card.reaction.supportFromRome.title");
        document.put("descriptionKey", "card.reaction.supportFromRome.description");
        document.put("price", 3);
        document.put("requiredInfluence", 8);
        document.put("requiredInfluenceCondition", IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL.toString());
        document.put("action", Collections.singletonList(SwitchGladiatorAction.getInstance()));
        Reaction reactionExpected = new Reaction(id.toHexString(), "card.reaction.supportFromRome.title",
                "Support from Rome.", "card.reaction.supportFromRome.description",
                "Foil a Scheme. You may retrive a Guard card from the discrad pile.",
                3, 8, IntrigueCard.RequiredInfluenceCondition.MORE_OR_EQUAL,
                Collections.singletonList(SwitchGladiatorAction.getInstance())
        );

        //when
        Reaction convertedReaction = reactionConverter.convert(document);

        //then
        assertEquals(reactionExpected, convertedReaction);
    }
}