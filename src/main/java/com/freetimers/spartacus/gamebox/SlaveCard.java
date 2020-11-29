package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.Action;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document

public class SlaveCard extends MarketCard {

    private final Integer attack;
    private final Integer defence;
    private final Integer speed;
    private final List<Action> actions;

    public SlaveCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price,
                     Integer attack, Integer defence, Integer speed, List<Action> actions) {
        super(id, titleKey, title, descriptionKey, description, price);
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.actions = actions;
    }

    public static SlaveCard of(String titleKey, String descriptionKey, Integer price, Integer attack, Integer defence,
                               Integer speed, List<Action> actions) {
        return new SlaveCard(null, titleKey, null, descriptionKey, null, price, attack, defence, speed, actions);
    }

    public static SlaveCard of(SlaveCard slaveCard, String title, String description){
        return new SlaveCard(
                slaveCard.getId(),
                slaveCard.getTitleKey(),
                title,
                slaveCard.getDescriptionKey(),
                description,
                slaveCard.getPrice(),
                slaveCard.getAttack(),
                slaveCard.getDefence(),
                slaveCard.getSpeed(),
                slaveCard.getActions());
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

    public List<Action> getActions() {
        return actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SlaveCard slaveCard = (SlaveCard) o;
        return Objects.equals(attack, slaveCard.attack) &&
                Objects.equals(defence, slaveCard.defence) &&
                Objects.equals(speed, slaveCard.speed) &&
                Objects.equals(actions, slaveCard.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence, speed, actions);
    }

    @Override
    public String toString() {
        return "SlaveCard{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", actions=" + actions +
                "} " + super.toString();
    }
}
