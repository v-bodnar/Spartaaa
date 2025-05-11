package com.freetimers.spartacus.dto;

public class GuardCardDto {
    private final String title;
    private final String description;
    private final Integer price;
    private final Integer requiredInfluence;

    public GuardCardDto(String title, String description, Integer price, Integer requiredInfluence) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.requiredInfluence = requiredInfluence;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getRequiredInfluence() {
        return requiredInfluence;
    }
}
