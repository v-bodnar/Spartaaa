package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.SchemeCard;
import com.freetimers.spartacus.translation.TranslationService;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

@Component
class AfterSchemeConvertCallback implements AfterConvertCallback<SchemeCard>, AfterSaveCallback<SchemeCard> {
    private final TranslationService translationService;

    public AfterSchemeConvertCallback(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public SchemeCard onAfterConvert(SchemeCard entity, Document document, String collection) {
        return translateSchemeCard(entity);
    }

    @Override
    public SchemeCard onAfterSave(SchemeCard entity, Document document, String collection) {
        return translateSchemeCard(entity);
    }

    private SchemeCard translateSchemeCard(SchemeCard schemeCard){
        String title = translationService.translate(schemeCard.getTitleKey());
        String description = translationService.translate(schemeCard.getDescriptionKey());

        return SchemeCard.of(schemeCard, title, description);
    }
}