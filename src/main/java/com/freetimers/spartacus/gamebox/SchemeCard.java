package com.freetimers.spartacus.gamebox;

import com.freetimers.spartacus.gamebox.action.Action;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class SchemeCard extends IntrigueCard {
    private final List<Action> actions;

    public SchemeCard(String id, String titleKey, String title, String descriptionKey, String description,
                      Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition, List<Action> actions) {
        super(id, titleKey, title, descriptionKey, description, price, requiredInfluence, requiredInfluenceCondition);
        this.actions = actions;
    }

    public static SchemeCard of(String titleKey, String descriptionKey,
                                Integer price, Integer requiredInfluence, RequiredInfluenceCondition requiredInfluenceCondition, List<Action> actions) {
        return new SchemeCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence, requiredInfluenceCondition, actions);
    }

    public static SchemeCard of(String titleKey, String descriptionKey,
                                Integer price, Integer requiredInfluence, List<Action> actions) {
        return new SchemeCard(null, titleKey, null, descriptionKey, null, price, requiredInfluence, RequiredInfluenceCondition.MORE_OR_EQUAL, actions);
    }

    public static SchemeCard of(SchemeCard schemeCard, String title, String description){
        return new SchemeCard(
                schemeCard.getId(),
                schemeCard.getTitleKey(),
                title,
                schemeCard.getDescriptionKey(),
                description,
                schemeCard.getPrice(),
                schemeCard.getRequiredInfluence(),
                schemeCard.getRequiredInfluenceCondition(),
                schemeCard.getActions());
    }

    public List<Action> getActions() {
        return actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchemeCard that = (SchemeCard) o;
        return Objects.equals(actions, that.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), actions);
    }

    @Override
    public String toString() {
        return "SchemeCard{" +
                "actions=" + actions +
                "} " + super.toString();
    }
}