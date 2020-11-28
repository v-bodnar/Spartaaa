package com.freetimers.spartacus.gamebox;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class AbstractCard implements Card {
    @Id
    private final String id;
    private final Integer price;
    private final String descriptionKey;
    private final String description;
    private final String titleKey;
    private final String title;


    public AbstractCard(String id, String titleKey, String title, String descriptionKey, String description, Integer price) {
        this.id = id;
        this.price = Objects.requireNonNull(price);
        this.descriptionKey = Objects.requireNonNull(descriptionKey);
        this.titleKey = Objects.requireNonNull(titleKey);
        this.description = description;
        this.title = title;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescriptionKey() {
        return descriptionKey;
    }

    @Override
    public String getTitleKey() {
        return titleKey;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCard that = (AbstractCard) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(descriptionKey, that.descriptionKey) &&
                Objects.equals(description, that.description) &&
                Objects.equals(titleKey, that.titleKey) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, descriptionKey, description, titleKey, title);
    }

    @Override
    public String toString() {
        return "AbstractCard{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", descriptionKey='" + descriptionKey + '\'' +
                ", description='" + description + '\'' +
                ", titleKey='" + titleKey + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
