package com.freetimers.spartacus.gamebox;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freetimers.spartacus.gamebox.action.Action;

import java.util.List;
import java.util.Objects;

public abstract class IntrigueCard extends AbstractCard {
    private final Integer requiredInfluence;
    private final RequiredInfluenceCondition requiredInfluenceCondition;

    @JsonIgnore
    private final List<Action> actions;

    public IntrigueCard(String id, String titleKey, String title, String descriptionKey, String description,
                        Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition, List<Action> actions) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.requiredInfluence = Objects.requireNonNull(requiredInfluence);
        this.requiredInfluenceCondition = Objects.requireNonNull(requiredInfluenceCondition);
        this.actions = Objects.requireNonNull(actions);
    }

    public Integer getRequiredInfluence() {
        return requiredInfluence;
    }

    public RequiredInfluenceCondition getRequiredInfluenceCondition() {
        return requiredInfluenceCondition;
    }

    public List<Action> getActions() {
        return actions;
    }

    public enum RequiredInfluenceCondition{
        MORE_THEN, MORE_OR_EQUAL, LESS_THEN
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IntrigueCard that = (IntrigueCard) o;
        return Objects.equals(requiredInfluence, that.requiredInfluence) &&
                requiredInfluenceCondition == that.requiredInfluenceCondition &&
                Objects.equals(actions, that.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requiredInfluence, requiredInfluenceCondition, actions);
    }

    @Override
    public String toString() {
        return "IntrigueCard{" +
                "requiredInfluence=" + requiredInfluence +
                ", requiredInfluenceCondition=" + requiredInfluenceCondition +
                ", action=" + actions +
                "} " + super.toString();
    }
}
