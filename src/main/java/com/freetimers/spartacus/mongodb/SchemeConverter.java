package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Scheme;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class SchemeConverter implements Converter<Document, Scheme> {
    private TranslationService translationService;

    public SchemeConverter(TranslationService translationService){
        this.translationService = translationService;
    }

    @Override
    public Scheme convert(Document value){
        return new Scheme(value.getObjectId("_id").toHexString(),
                value.getString("titleKey"),
                translationService.translate(value.getString("titleKey")),
                value.getString("descriptionKey"),
                translationService.translate(value.getString("descriptionKey")),
                value.getInteger("price"),
                value.getInteger("requiredInfluence"),
                IntrigueCard.RequiredInfluenceCondition.valueOf(value.getString("requiredInfluenceCondition")));
    }
}
