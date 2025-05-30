package com.freetimers.spartacus.dto;

import com.freetimers.spartacus.gamebox.IntrigueCard;

public class IntrigueCardDto {
    private final String title;
    private final String description;
    private final Integer price;
    private final Integer requiredInfluence;

    public IntrigueCardDto(String title, String description, Integer price, Integer requiredInfluence) {
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
