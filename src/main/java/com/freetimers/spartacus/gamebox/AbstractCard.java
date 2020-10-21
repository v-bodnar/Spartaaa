package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.aop.Translate;
import org.springframework.data.annotation.Id;

import java.util.Objects;

public abstract class AbstractCard implements Card {
    private final int price;
    private final String description;
    private final String title;
    @Id
    private String id;

    public AbstractCard(int price, String title, String description) {
        this.price = price;
        this.description = description;
        this.title = title;

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Translate
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    @Translate
    public String getTitle() {
        return title;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCard that = (AbstractCard) o;
        return price == that.price &&
                Objects.equals(description, that.description) &&
                Objects.equals(title, that.title) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, description, title, id);
    }

    @Override
    public String toString() {
        return "AbstractCard{" +
                "price=" + price +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
