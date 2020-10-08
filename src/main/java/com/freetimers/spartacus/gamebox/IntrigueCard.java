package com.freetimers.spartacus.gamebox;

public abstract class IntrigueCard extends AbstractCard {
    private final byte requiredInfluence;

    public IntrigueCard(byte requiredInfluence, byte price, String description) {
        super (price, description);
        this.requiredInfluence = requiredInfluence;
    }

    public byte getRequiredInfluence() {
        return requiredInfluence;
    }
}
