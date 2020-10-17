package com.freetimers.spartacus.gamebox;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;

import java.util.function.Predicate;


public class Scheme extends IntrigueCard {


    @Transient
    private Predicate predicate;

    @PersistenceConstructor
    public Scheme(int requiredInfluence, int price, String title, String description) {
        super(requiredInfluence, price, title,  description);
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }
}