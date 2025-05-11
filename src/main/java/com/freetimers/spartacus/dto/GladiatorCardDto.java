package com.freetimers.spartacus.dto;

public class GladiatorCardDto {
    private final Integer price;
    private final String description;
    private final String title;
    private final Integer attack;
    private final Integer defence;
    private final Integer speed;
    private final boolean starting;

    public GladiatorCardDto(Integer price, String description, String title, Integer attack, Integer defence, Integer speed, boolean starting) {
        this.price = price;
        this.description = description;
        this.title = title;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.starting = starting;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
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
}
