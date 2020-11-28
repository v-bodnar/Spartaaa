package com.freetimers.spartacus.mongodb;

import com.freetimers.spartacus.gamebox.ReactionCard;
import com.freetimers.spartacus.translation.TranslationService;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;

@Component
class AfterReactionConvertCallback implements AfterConvertCallback<ReactionCard>, AfterSaveCallback<ReactionCard> {
    private final TranslationService translationService;

    public AfterReactionConvertCallback(TranslationService translationService) {
        this.translationService = translationService;
    }

    @Override
    public ReactionCard onAfterConvert(ReactionCard entity, Document document, String collection) {
        return translateReactionCard(entity);
    }

    @Override
    public ReactionCard onAfterSave(ReactionCard entity, Document document, String collection) {
        return translateReactionCard(entity);
    }

    private ReactionCard translateReactionCard(ReactionCard reactionCard){
        String title = translationService.translate(reactionCard.getTitleKey());
        String description = translationService.translate(reactionCard.getDescriptionKey());

        return ReactionCard.of(reactionCard, title, description);
    }
}