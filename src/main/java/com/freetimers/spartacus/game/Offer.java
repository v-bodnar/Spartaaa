package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.Card;

import java.util.Objects;

 class Offer {
    private final String id;
    private final Dominus source;
    private final Card card;
    private final Integer goldCoins;
    private final Dominus target;
    private final OfferState state;

    public Offer(String id, Dominus source, Card card, Integer goldCoins, Dominus target, OfferState state) {
        this.id = id;
        this.source = source;
        this.card = card;
        this.goldCoins = goldCoins;
        this.target = target;
        this.state = state;
    }

     String getId() {
        return id;
    }

     Dominus getSource() {
        return source;
    }

     Card getCard() {
        return card;
    }

     Integer getGoldCoins() {
        return goldCoins;
    }

     Dominus getTarget() {
        return target;
    }

     OfferState getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) &&
                Objects.equals(source, offer.source) &&
                Objects.equals(card, offer.card) &&
                Objects.equals(goldCoins, offer.goldCoins) &&
                Objects.equals(target, offer.target) &&
                state == offer.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, card, goldCoins, target, state);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", card=" + card +
                ", goldCoins=" + goldCoins +
                ", target=" + target +
                ", state=" + state +
                '}';
    }
}
