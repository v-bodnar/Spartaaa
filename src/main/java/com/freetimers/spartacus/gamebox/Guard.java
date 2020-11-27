package com.freetimers.spartacus.gamebox;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class Guard extends IntrigueCard {

    private final Condition condition;
    private final List<Action> action;

    public Guard(String id, String titleKey, String title, String descriptionKey, String description,
                 Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition,
                 Condition condition, List<Action> action)
    {super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition);
        this.condition = condition;
        this.action = action;
    }
    public static Guard of(String titleKey, String descriptionKey, Integer price, Integer requiredInfluence,
                              RequiredInfluenceCondition requiredInfluenceCondition, Condition condition, List<Action> action) {
        return new Guard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                requiredInfluenceCondition, condition, action);
    }

    public static Guard of(String titleKey, String descriptionKey,
                              Integer price, Integer requiredInfluence,List<Action> action) {
        return new Guard(null, titleKey, null, descriptionKey, null, price, requiredInfluence,
                RequiredInfluenceCondition.MORE_OR_EQUAL, Condition.READY, action);
    }

    public Condition getCondition() {
        return condition;
    }

    public List<Action> getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guard guard = (Guard) o;
        return condition == guard.condition &&
                Objects.equals(action, guard.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), condition, action);
    }

    @Override
    public String toString() {
        return "Guard{" +
                "condition=" + condition +
                ", action=" + action +
                '}';
    }
}
