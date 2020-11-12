package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Equip extends MarketCard {

    private final EquipType type;

    public Equip(String id, String titleKey, String title, String descriptionKey, String description, Integer price, EquipType type) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.type = type;
    }

    public static Equip of(String titleKey, String descriptionKey, Integer price, EquipType type){
        return new Equip(null, titleKey,null, descriptionKey, null, price, type);
    }

    public EquipType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Equip equip = (Equip) o;
        return type == equip.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "Equip{" +
                "type=" + type +
                '}';
    }
}
