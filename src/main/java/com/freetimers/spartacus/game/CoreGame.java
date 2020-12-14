package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.*;

import javax.swing.plaf.nimbus.State;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class CoreGame implements Game {

    private Instant startTime;
    private Instant finishedTime;
    private List<Dominus> listDominus;
    private Deck<MarketCard> marketDeck;
    private Deck<IntrigueCard> intrigueDeck;
    private Phase gamePhase;
    private GameState gameState;
    private List<UpkeepPhase> upkeepPhase;
    private List<IntriguePhase> intriguePhase;
    private List<MarketPhase> marketPhase;
    private List<ArenaPhase> arenaPhase;

    public CoreGame() {
        startTime = Instant.now();
        gamePhase = Phase.LOBBY;
        gameState = GameState.NEW;
        listDominus = new LinkedList<>();
        marketDeck = new Deck<> (new LinkedList<>());// todo pass cards to deck
        intrigueDeck = new Deck<>(new LinkedList<>());
        upkeepPhase = new LinkedList<>();
        intriguePhase = new LinkedList<>();
        marketPhase = new LinkedList<>();
        arenaPhase = new LinkedList<>();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean connect(String password) {
        return false;
    }

    @Override
    public void selectDominus(Player player) {

    }

    @Override
    public int getRound() {
        return 0;
    }

    @Override
    public void chooseGladiatorsToRelease(Dominus dominus) {

    }

    @Override
    public Dominus getActiveDominus() {
        return null;
    }

    @Override
    public void requestHelp(Dominus source, Dominus target, Intrigue intrigue) {

    }

    @Override
    public CompletionStage<Void> playIntrigue(Dominus source, Dominus target, Intrigue intrigue) {
        return null;
    }

    @Override
    public void sellIntrigue(IntrigueCard intrigue) {

    }

    @Override
    public void useDominusSkill(Dominus dominus) {

    }

    @Override
    public CompletionStage<Void> playReaction(Dominus source, ReactionCard reaction, IntrigueCard intrigue) {
        return null;
    }

    @Override
    public void finishTurn(Dominus dominus) {

    }

    @Override
    public CompletionStage<Void> makeOffer(Offer offer) {
        return null;
    }

    @Override
    public void acceptOffer(Offer offer) {

    }

    @Override
    public void declineOffer(Offer offer) {

    }

    @Override
    public void sellCard(Dominus dominus, Card card) {

    }

    @Override
    public void finishTrading(Dominus dominus) {

    }

    @Override
    public void makeBet(Dominus source, int goldCoins) {

    }

    @Override
    public void prepareNewGame() {
        marketDeck.shuffle();
        intrigueDeck.shuffle();
    }
}
