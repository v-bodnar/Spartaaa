package com.freetimers.spartacus.gamebox;

public class Equip extends MarketCard {

    private final EquipType type;

    public Equip(int price, EquipType type, String title, String description) {
        super(price, title, description);
        this.type = type;
    }

    public EquipType getType() {
        return type;
    }
}
