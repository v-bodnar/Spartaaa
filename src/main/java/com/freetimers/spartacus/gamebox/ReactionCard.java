package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.Action;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ReactionCard extends IntrigueCard {


    public ReactionCard(String id, String titleKey, String title, String descriptionKey, String description,
                        Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition,
                        List<Action> action) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition, action);
    }

    public static ReactionCard of(String titleKey, String descriptionKey,
                                  Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition,
                                  List<Action> action) {
        return new ReactionCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                requiredInfluenceCondition, action);
    }

    public static ReactionCard of(String titleKey, String descriptionKey,
                                  Integer price, Integer requiredInfluence, List<Action> action) {
        return new ReactionCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                RequiredInfluenceCondition.MORE_OR_EQUAL, action);
    }

    public static ReactionCard of(ReactionCard reactionCard, String title, String description) {
        return new ReactionCard(
                reactionCard.getId(),
                reactionCard.getTitleKey(),
                title,
                reactionCard.getDescriptionKey(),
                description,
                reactionCard.getPrice(),
                reactionCard.getRequiredInfluence(),
                reactionCard.getRequiredInfluenceCondition(),
                reactionCard.getActions());
    }


    @Override
    public String toString() {
        return "ReactionCard{} " + super.toString();
    }
}
