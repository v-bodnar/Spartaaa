package com.freetimers.spartacus.gamebox;

public abstract class IntrigueCard extends AbstractCard {
    private final int requiredInfluence;

    public IntrigueCard(String id, int requiredInfluence, int price, String title, String description) {
        super(id, price, title, description);
        this.requiredInfluence = requiredInfluence;
    }

    public int getRequiredInfluence() {
        return requiredInfluence;
    }
}
