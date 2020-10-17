package com.freetimers.spartacus.gamebox;

public class Game {
    private Deck<MarketCard> marketDeck=new Deck<>();
    private Deck<IntrigueCard> intrigueDeck=new Deck<>();
    public void initialize(){
        marketDeck.addCard(new Slave((int) 2, "Title:", "Description"));
    }
}
