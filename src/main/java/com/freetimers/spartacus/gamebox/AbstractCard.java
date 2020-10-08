package com.freetimers.spartacus.gamebox;

public abstract class AbstractCard implements Card {
    private final byte price;
    private final String description;

    public AbstractCard(byte price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public byte getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
