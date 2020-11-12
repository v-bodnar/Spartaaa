package com.freetimers.spartacus.gamebox;

public abstract class MarketCard extends AbstractCard{
    public MarketCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price) {
        super(id, titleKey, title, descriptionKey, description, price);
    }
}
