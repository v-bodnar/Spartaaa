package com.freetimers.spartacus.gamebox;

import java.util.Objects;

public abstract class IntrigueCard extends AbstractCard {
    private final Integer requiredInfluence;
    private final RequiredInfluenceCondition requiredInfluenceCondition;

    public IntrigueCard(String id, String titleKey, String title, String descriptionKey, String description,
                        Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.requiredInfluence = Objects.requireNonNull(requiredInfluence);
        this.requiredInfluenceCondition = Objects.requireNonNull(requiredInfluenceCondition);
    }

    public Integer getRequiredInfluence() {
        return requiredInfluence;
    }

    public RequiredInfluenceCondition getRequiredInfluenceCondition() {
        return requiredInfluenceCondition;
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
                requiredInfluenceCondition == that.requiredInfluenceCondition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requiredInfluence, requiredInfluenceCondition);
    }

    @Override
    public String toString() {
        return "IntrigueCard{" +
                "requiredInfluence=" + requiredInfluence +
                ", requiredInfluenceCondition=" + requiredInfluenceCondition +
                '}';
    }
}
