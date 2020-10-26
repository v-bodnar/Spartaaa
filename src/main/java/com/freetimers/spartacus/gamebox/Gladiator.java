package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
public class Gladiator extends MarketCard {

    private final Integer attack;
    private final Integer defence;
    private final Integer speed;

    public Gladiator(String id, String titleKey, String title, String descriptionKey, String description, Integer price, Integer attack, Integer defence, Integer speed) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public static Gladiator of(String titleKey, String descriptionKey, Integer price,  Integer attack, Integer defence, Integer speed) {
        return new Gladiator(null, titleKey, null, descriptionKey, null, price, attack, defence, speed);
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
        Gladiator gladiator = (Gladiator) o;
        return Objects.equals(attack, gladiator.attack) &&
                Objects.equals(defence, gladiator.defence) &&
                Objects.equals(speed, gladiator.speed);
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
                '}';
    }
}
