package com.freetimers.spartacus.gamebox;

import java.util.Objects;

public abstract class MarketCard extends AbstractCard{

    private final Condition condition;

    public MarketCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price, Condition condition) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MarketCard that = (MarketCard) o;
        return condition == that.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), condition);
    }

    @Override
    public String toString() {
        return "MarketCard{" +
                "condition=" + condition +
                '}';
    }
}
