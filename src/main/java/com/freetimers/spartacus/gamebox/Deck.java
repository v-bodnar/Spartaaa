package com.freetimers.spartacus.gamebox;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Deck<T> {
    private final LinkedList<T> cardList;

    public Deck() {
        this(new LinkedList<>());
    }

    @PersistenceConstructor
    public Deck(List<T> cardList) {
        this.cardList = new LinkedList<>(cardList);
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public void addCard(T card) {
        cardList.add(card);
    }

    public Optional<T> getTop() {
        return Optional.ofNullable(cardList.pollLast());
    }

    public Optional<T> getBottom() {
        return Optional.ofNullable(cardList.pollFirst());
    }
}
