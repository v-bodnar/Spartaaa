package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.Gladiator;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

public class GladiatorConverter implements Converter<Document, Gladiator> {

    private TranslationService translationService;

    public GladiatorConverter(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public Gladiator convert(Document value) {
        return new Gladiator(value.getObjectId("_id").toHexString(),
                value.getString("titleKey"),
                translationService.translate(value.getString("titleKey")),
                value.getString("descriptionKey"),
                translationService.translate(value.getString("descriptionKey")),
                value.getInteger("price"),
                value.getInteger("attack"),
                value.getInteger("defence"),
                value.getInteger("speed"));
    }


}
