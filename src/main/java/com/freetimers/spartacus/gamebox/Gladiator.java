package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Gladiator extends MarketCard {
    public Gladiator(String id, int price, String title, String description) {
        super(id, price, title, description);
    }
}
