package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class EquipmentCard extends MarketCard {

    private final EquipType type;

    public EquipmentCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price,
                         EquipType type, Condition condition) {
        super(id, titleKey, title, descriptionKey, description, price, condition);
        this.type = type;
    }

    public static EquipmentCard of(String titleKey, String descriptionKey, Integer price, EquipType type, Condition condition){
        return new EquipmentCard(null, titleKey,null, descriptionKey, null, price, type, condition);
    }

    public static EquipmentCard of(EquipmentCard equipmentCard, String title, String description){
        return new EquipmentCard(
                equipmentCard.getId(),
                equipmentCard.getTitleKey(),
                title,
                equipmentCard.getDescriptionKey(),
                description,
                equipmentCard.getPrice(),
                equipmentCard.getType(),
                equipmentCard.getCondition());
    }

    public EquipType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EquipmentCard that = (EquipmentCard) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "EquipmentCard{" +
                "type=" + type +
                "} " + super.toString();
    }
}
