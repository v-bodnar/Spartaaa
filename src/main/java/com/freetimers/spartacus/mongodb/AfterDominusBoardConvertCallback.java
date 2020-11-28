package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.DominusBoard;
import com.freetimers.spartacus.translation.TranslationService;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

@Component
class AfterDominusBoardConvertCallback implements AfterConvertCallback<DominusBoard>, AfterSaveCallback<DominusBoard> {
    private final TranslationService translationService;

    public AfterDominusBoardConvertCallback(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public DominusBoard onAfterConvert(DominusBoard entity, Document document, String collection) {
        return translateDominusBoard(entity);
    }

    @Override
    public DominusBoard onAfterSave(DominusBoard entity, Document document, String collection) {
        return translateDominusBoard(entity);
    }

    private DominusBoard translateDominusBoard(DominusBoard dominusBoard){
        String title = translationService.translate(dominusBoard.getTitleKey());
        String description = translationService.translate(dominusBoard.getDescriptionKey());

        return DominusBoard.of(dominusBoard, title, description);
    }
}