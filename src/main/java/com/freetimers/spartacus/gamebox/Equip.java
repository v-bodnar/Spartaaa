package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Equip extends MarketCard {

    private final EquipType type;

    public Equip(String id, int price, EquipType type, String title, String description) {
        super(id, price, title, description);
        this.type = type;
    }

    public EquipType getType() {
        return type;
    }
}
