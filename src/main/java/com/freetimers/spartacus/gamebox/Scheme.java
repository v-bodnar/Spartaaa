package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Scheme extends IntrigueCard {
    public Scheme(String id, String titleKey, String title, String descriptionKey, String description,
                  Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition);
    }

    public static Scheme of(String titleKey, String descriptionKey,
                            Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition) {
        return new Scheme(null, titleKey, null, descriptionKey, null, price, requiredInfluence, requiredInfluenceCondition);
    }

    public static Scheme of(String titleKey, String descriptionKey,
                            Integer price, Integer requiredInfluence) {
        return new Scheme(null, titleKey, null, descriptionKey, null, price, requiredInfluence, RequiredInfluenceCondition.MORE_OR_EQUAL);
    }
}