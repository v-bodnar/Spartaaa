package com.freetimers.spartacus.gamebox;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

public class Deck<T extends Card> {
    private final LinkedList<T> cardList = new LinkedList<>();

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public void addCard(T card) {
        cardList.add(card);
    }

    public Optional<T> getTop() {
        return Optional.ofNullable(cardList.pollLast());
    }
    public Optional<T> getBottom(){
        return Optional.ofNullable(cardList.pollFirst());
    }
}
