package com.freetimers.spartacus.gamebox;

import java.util.function.Predicate;

public class Reaction extends IntrigueCard {
    private final Predicate predicate;

    public Reaction(Predicate predicate, int requiredInfluence, int price, String title, String description) {
        super(requiredInfluence, price, title, description);
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
