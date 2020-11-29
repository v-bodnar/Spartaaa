package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.Action;

import java.util.List;
import java.util.Objects;

public class GuardCard extends IntrigueCard {
    private final List<Action> action;

    public GuardCard(String id, String titleKey, String title, String descriptionKey, String description,
                     Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition,
                     List<Action> action)
    {super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition);
        this.action = action;
    }
    public static GuardCard of(String titleKey, String descriptionKey, Integer price, Integer requiredInfluence,
                               RequiredInfluenceCondition requiredInfluenceCondition, List<Action> action) {
        return new GuardCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                requiredInfluenceCondition, action);
    }

    public static GuardCard of(String titleKey, String descriptionKey,
                               Integer price, Integer requiredInfluence, List<Action> action) {
        return new GuardCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                RequiredInfluenceCondition.MORE_OR_EQUAL, action);
    }

    public List<Action> getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GuardCard guardCard = (GuardCard) o;
        return Objects.equals(action, guardCard.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), action);
    }

    @Override
    public String toString() {
        return "GuardCard{" +
                "action=" + action +
                "} " + super.toString();
    }
}
