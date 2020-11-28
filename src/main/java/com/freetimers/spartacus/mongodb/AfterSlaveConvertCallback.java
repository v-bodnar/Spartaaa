package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.SlaveCard;
import com.freetimers.spartacus.translation.TranslationService;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

@Component
class AfterSlaveConvertCallback implements AfterConvertCallback<SlaveCard>, AfterSaveCallback<SlaveCard> {
    private final TranslationService translationService;

    public AfterSlaveConvertCallback(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public SlaveCard onAfterConvert(SlaveCard entity, Document document, String collection) {
        return translateSlaveCard(entity);
    }

    @Override
    public SlaveCard onAfterSave(SlaveCard entity, Document document, String collection) {
        return translateSlaveCard(entity);
    }

    private SlaveCard translateSlaveCard(SlaveCard slaveCard) {
        String title = translationService.translate(slaveCard.getTitleKey());
        String description = translationService.translate(slaveCard.getDescriptionKey());

        return SlaveCard.of(slaveCard, title, description);
    }
}