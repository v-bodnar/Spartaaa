package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Slave extends MarketCard {
    public Slave(String id, String titleKey, String title, String descriptionKey, String description, Integer price) {
        super(id, titleKey, title, descriptionKey, description, price);
    }
}
