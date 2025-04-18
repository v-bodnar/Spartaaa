package com.freetimers.spartacus.gamebox;

import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public List<T> getFiltered(int num, Predicate<T> filter){
        List<T> topCards = new LinkedList<>();
        LinkedList<T> filteredCards = cardList.stream().filter(filter).collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < num; i++) {
            Optional<T> card = Optional.ofNullable(filteredCards.pollLast());
            card.ifPresent(topCards::add);
        }
        return topCards;
    }
}
