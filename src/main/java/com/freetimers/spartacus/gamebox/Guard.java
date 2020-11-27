package com.freetimers.spartacus.gamebox;

public class Guard extends IntrigueCard {

    private final Condition condition;

    public Guard(String id, String titleKey, String title, String descriptionKey, String description,
                 Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition, Condition condition) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition);
        this.condition = condition;
    }
    public static Guard of(String titleKey, String descriptionKey, Integer price, Integer requiredInfluence,
                              RequiredInfluenceCondition requiredInfluenceCondition, Condition condition) {
        return new Guard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                requiredInfluenceCondition, condition);
    }

    public static Guard of(String titleKey, String descriptionKey,
                              Integer price, Integer requiredInfluence) {
        return new Guard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                RequiredInfluenceCondition.MORE_OR_EQUAL, Condition.READY );
    }
}
