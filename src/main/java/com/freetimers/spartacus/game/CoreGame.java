package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.*;
import com.freetimers.spartacus.utils.FileUtils;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletionStage;

public class CoreGame implements Game {

    @Id
    private String id;
    private String password;
    private Instant startTime;
    private Instant finishedTime;
    private List<Dominus> dominusList;
    private Deck<MarketCard> marketDeck;
    private Deck<IntrigueCard> intrigueDeck;
    private Phase gamePhase;
    private GameState gameState;
    private List<UpkeepPhase> upkeepPhase;
    private List<IntriguePhase> intriguePhase;
    private List<MarketPhase> marketPhase;
    private List<ArenaPhase> arenaPhase;


    public CoreGame(Deck<MarketCard> marketDeck, Deck<IntrigueCard> intrigueDeck) {
        this.startTime = Instant.now();
        this.gamePhase = Phase.LOBBY;
        this.gameState = GameState.NEW;
        this.marketDeck = marketDeck;
        this.intrigueDeck = intrigueDeck;
        this.dominusList = new LinkedList<>();
        this.upkeepPhase = new LinkedList<>();
        this.intriguePhase = new LinkedList<>();
        this.marketPhase = new LinkedList<>();
        this.arenaPhase = new LinkedList<>();
        this.password = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean connect(String password) {
        return false;
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

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getFinishedTime() {
        return finishedTime;
    }

    public List<Dominus> getDominusList() {
        return dominusList;
    }

    public Phase getGamePhase() {
        return gamePhase;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<UpkeepPhase> getUpkeepPhase() {
        return upkeepPhase;
    }

    public List<IntriguePhase> getIntriguePhase() {
        return intriguePhase;
    }

    public List<MarketPhase> getMarketPhase() {
        return marketPhase;
    }

    public List<ArenaPhase> getArenaPhase() {
        return arenaPhase;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void selectDominus(DominusBoard dominusBoard, String playersName, String sessionToken) {
        Player player = new Player(playersName, sessionToken, FileUtils.getInstance().getBase64encodedFile
                ("images/defaultava.jpg"));
        Dominus selectedDominus = new Dominus(dominusBoard, player, new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>(), new LinkedList<>());
        dominusList.add(selectedDominus);
    }

    public void releaseSelectedDominus(String playersName){
        dominusList.removeIf(dominus -> playersName.equals(dominus.getPlayersName()));
    }
}
