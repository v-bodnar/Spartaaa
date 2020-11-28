package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.translation.TranslationService;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

@Component
class AfterGladiatorConvertCallback implements AfterConvertCallback<GladiatorCard>, AfterSaveCallback<GladiatorCard> {
    private final TranslationService translationService;

    public AfterGladiatorConvertCallback(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public GladiatorCard onAfterConvert(GladiatorCard entity, Document document, String collection) {
        return translateGladiatorCard(entity);
    }

    @Override
    public GladiatorCard onAfterSave(GladiatorCard entity, Document document, String collection) {
        return translateGladiatorCard(entity);
    }

    private GladiatorCard translateGladiatorCard(GladiatorCard gladiatorCard){
        String title = translationService.translate(gladiatorCard.getTitleKey());
        String description = translationService.translate(gladiatorCard.getDescriptionKey());

        return GladiatorCard.of(gladiatorCard, title, description);
    }
}