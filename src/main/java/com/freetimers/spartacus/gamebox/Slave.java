package com.freetimers.spartacus.gamebox;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document

public class Slave extends MarketCard {

    private final Integer attack;
    private final Integer defence;
    private final Integer speed;

    public Slave(String id, String titleKey, String title, String descriptionKey, String description, Integer price,
                 Integer attack, Integer defence, Integer speed, Condition condition) {
        super(id, titleKey, title, descriptionKey, description, price, condition);
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public static Slave of(String titleKey, String descriptionKey, Integer price, Integer attack, Integer defence,
                           Integer speed, Condition condition) {
        return new Slave(null, titleKey, null, descriptionKey, null, price, attack, defence, speed,
                condition);
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
        Slave slave = (Slave) o;
        return Objects.equals(attack, slave.attack) &&
                Objects.equals(defence, slave.defence) &&
                Objects.equals(speed, slave.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence, speed);
    }

    @Override
    public String toString() {
        return "Slave{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                "} " + super.toString();
    }
}
