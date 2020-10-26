package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reaction extends IntrigueCard {
    public Reaction(String id, String titleKey, String title, String descriptionKey, String description, Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition);
    }
}
