package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
public class GladiatorCard extends MarketCard {

    private final Integer attack;
    private final Integer defence;
    private final Integer speed;

    public GladiatorCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price,
                         Integer attack, Integer defence, Integer speed, Condition condition) {
        super(id, titleKey, title, descriptionKey, description, price, condition);
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public static GladiatorCard of(String titleKey, String descriptionKey, Integer price, Integer attack, Integer defence,
                                   Integer speed, Condition condition) {
        return new GladiatorCard(null, titleKey, null, descriptionKey, null, price, attack, defence, speed,
                condition);
    }

    public static GladiatorCard of(GladiatorCard gladiatorCard, String title, String description){
        return new GladiatorCard(
                gladiatorCard.getId(),
                gladiatorCard.getTitleKey(),
                title,
                gladiatorCard.getDescriptionKey(),
                description,
                gladiatorCard.getPrice(),
                gladiatorCard.getAttack(),
                gladiatorCard.getDefence(),
                gladiatorCard.getSpeed(),
                gladiatorCard.getCondition());
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public Integer getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GladiatorCard gladiatorCard = (GladiatorCard) o;
        return Objects.equals(attack, gladiatorCard.attack) &&
                Objects.equals(defence, gladiatorCard.defence) &&
                Objects.equals(speed, gladiatorCard.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence, speed);
    }

    @Override
    public String toString() {
        return "Gladiator{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                "} " + super.toString();
    }
}
