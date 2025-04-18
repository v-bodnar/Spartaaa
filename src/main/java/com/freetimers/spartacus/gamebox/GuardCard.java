package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.Action;

import java.util.List;

public class GuardCard extends ReactionCard{
    public GuardCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition, List<Action> actions) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition, actions);
    }
}
