package com.freetimers.spartacus.gamebox;

import java.util.Collections;

public class GuardCard extends IntrigueCard {

    public GuardCard(String id, String titleKey, String title, String descriptionKey, String description,
                     Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition, Collections.emptyList());

    }

    public static GuardCard of(String titleKey, String descriptionKey, Integer price, Integer requiredInfluence,
                               RequiredInfluenceCondition requiredInfluenceCondition) {
        return new GuardCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                requiredInfluenceCondition);
    }

    public static GuardCard of(String titleKey, String descriptionKey,
                               Integer price, Integer requiredInfluence) {
        return new GuardCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                RequiredInfluenceCondition.MORE_OR_EQUAL);
    }

    @Override
    public String toString() {
        return "GuardCard{} " + super.toString();
    }
}
