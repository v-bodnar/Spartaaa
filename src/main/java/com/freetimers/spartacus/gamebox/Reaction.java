package com.freetimers.spartacus.gamebox;

import java.util.function.Predicate;

public class Reaction extends IntrigueCard {
    private final Predicate predicate;

    public Reaction(Predicate predicate, byte requiredInfluance, byte price, String description) {
        super(requiredInfluance, price, description);
        this.predicate = predicate;
    }

    public Predicate getPredicate() {
        return predicate;
    }
}
