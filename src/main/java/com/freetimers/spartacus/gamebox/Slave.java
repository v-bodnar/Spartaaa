package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Slave extends MarketCard {
    public Slave(String id, int price, String title, String description) {
        super(id, price, title, description);
    }
}
