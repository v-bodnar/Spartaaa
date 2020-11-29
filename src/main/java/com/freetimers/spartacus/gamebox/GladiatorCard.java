package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
public class GladiatorCard extends MarketCard {

    private final Integer attack;
    private final Integer defence;
    private final Integer speed;
    private final boolean starting;

    public GladiatorCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price,
                         Integer attack, Integer defence, Integer speed, boolean starting) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.starting = starting;
    }

    public static GladiatorCard of(String titleKey, String descriptionKey, Integer price, Integer attack, Integer defence,
                                   Integer speed, boolean starting) {
        return new GladiatorCard(null, titleKey, null, descriptionKey, null, price, attack, defence, speed,
                starting);
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
                gladiatorCard.isStarting());
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

    public boolean isStarting() {
        return starting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GladiatorCard that = (GladiatorCard) o;
        return starting == that.starting &&
                Objects.equals(attack, that.attack) &&
                Objects.equals(defence, that.defence) &&
                Objects.equals(speed, that.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence, speed, starting);
    }

    @Override
    public String toString() {
        return "GladiatorCard{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", starting=" + starting +
                "} " + super.toString();
    }
}
