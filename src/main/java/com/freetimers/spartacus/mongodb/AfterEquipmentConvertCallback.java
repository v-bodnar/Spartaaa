package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.EquipmentCard;
import com.freetimers.spartacus.translation.TranslationService;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

@Component
class AfterEquipmentConvertCallback implements AfterConvertCallback<EquipmentCard>, AfterSaveCallback<EquipmentCard> {
    private final TranslationService translationService;

    public AfterEquipmentConvertCallback(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public EquipmentCard onAfterConvert(EquipmentCard entity, Document document, String collection) {
        return translateEquipmentCard(entity);
    }

    @Override
    public EquipmentCard onAfterSave(EquipmentCard entity, Document document, String collection) {
        return translateEquipmentCard(entity);
    }

    private EquipmentCard translateEquipmentCard(EquipmentCard equipmentCard){
        String title = translationService.translate(equipmentCard.getTitleKey());
        String description = translationService.translate(equipmentCard.getDescriptionKey());

        return EquipmentCard.of(equipmentCard, title, description);
    }
}