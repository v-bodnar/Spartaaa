package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.Action;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;


@Document
public class GladiatorCard extends MarketCard {

    private final Integer attack;
    private final Integer defence;
    private final Integer speed;
    private final boolean starting;
    private final List<Action> actions;

    public GladiatorCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price,
                         Integer attack, Integer defence, Integer speed, boolean starting, List<Action> actions) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.starting = starting;
        this.actions = actions;
    }

    public static GladiatorCard of(String titleKey, String descriptionKey, Integer price, Integer attack, Integer defence,
                                   Integer speed, boolean starting, List<Action> actions) {
        return new GladiatorCard(null, titleKey, null, descriptionKey, null, price, attack, defence, speed,
                starting, actions);
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
                gladiatorCard.isStarting(),
                gladiatorCard.getActions());
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

    public List<Action> getActions(){return actions; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GladiatorCard that = (GladiatorCard) o;
        return starting == that.starting &&
                Objects.equals(attack, that.attack) &&
                Objects.equals(defence, that.defence) &&
                Objects.equals(speed, that.speed)&&
                Objects.equals(actions, that.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence, speed, starting, actions);
    }

    @Override
    public String toString() {
        return "GladiatorCard{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", starting=" + starting +
                ", actions" + actions +
                "} " + super.toString();
    }
}
