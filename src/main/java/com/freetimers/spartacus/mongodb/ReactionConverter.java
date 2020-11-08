package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Reaction;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class ReactionConverter implements Converter<Document, Reaction> {

    private TranslationService translationService;

    public ReactionConverter(TranslationService translationService) {
        this.translationService = translationService;
    }

    public Reaction convert(Document value) {
        return new Reaction(value.getObjectId("_id").toHexString(),
                value.getString("titleKey"),
                translationService.translate(value.getString("titleKey")),
                value.getString("descriptionKey"),
                translationService.translate(value.getString("descriptionKey")),
                value.getInteger("price"),
                value.getInteger("requiredInfluence"),
                IntrigueCard.RequiredInfluenceCondition.valueOf(value.getString("requiredInfluenceCondition")));
    }
}
