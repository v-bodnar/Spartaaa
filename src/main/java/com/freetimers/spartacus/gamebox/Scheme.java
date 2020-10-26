package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Scheme extends IntrigueCard {
    public Scheme(String id, int requiredInfluence, int price, String title, String description) {
        super(id, requiredInfluence, price, title, description);
    }
}