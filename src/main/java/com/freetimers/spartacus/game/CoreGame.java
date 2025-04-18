package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.*;
import com.freetimers.spartacus.utils.FileUtils;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

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

    private int round = 0;


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

    public void startGame() {
        dominusList.forEach(dominus -> {
            dominus.setInfluence(7);
            dominus.giveGold(dominus.getDominusBoard().getStartingGold());
            dominus.giveCards(marketDeck.getFiltered(dominus.getDominusBoard().getStartingGladiators(),
                    GladiatorCard.class::isInstance));
            dominus.giveCards(marketDeck.getFiltered(dominus.getDominusBoard().getStartingSlaves(),
                    SlaveCard.class::isInstance));
            dominus.giveCards(intrigueDeck.getFiltered(dominus.getDominusBoard().getStartingGuards(),
                    GuardCard.class::isInstance));
        });
        gamePhase = Phase.INTRIGUE;
    }

    @Override
    public int getRound() {
        return round;
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
    public void selectDominus(DominusBoard dominusBoard, String playersName, String sessionId, boolean gameOwner) {
        Player player = new Player(playersName, sessionId, FileUtils.getInstance().getBase64encodedFile
                ("images/defaultava.png"),gameOwner);
        Dominus selectedDominus = new Dominus(dominusBoard, player);
        dominusList.add(selectedDominus);
    }

    @Override
    public void resetPlayersSessionId(String playerName, String sessionId) {
        Optional<Dominus> dominusOpt = dominusList.stream()
                .filter(dominus -> dominus.getPlayer().getName().equals(playerName))
                .findFirst();
        if (dominusOpt.isPresent()) {
            Dominus dominus = dominusOpt.get();
            dominus.setPlayersSessionId(sessionId);
        } else {
            throw new IllegalStateException("Dominus not found for player: " + playerName);
        }

    }

    public void releaseSelectedDominus(String playersName){
        dominusList.removeIf(dominus -> playersName.equals(dominus.getPlayersName()));
    }

    @Override
    public String toString() {
        return "CoreGame{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", startTime=" + startTime +
                ", finishedTime=" + finishedTime +
                ", dominusList=" + dominusList.stream().map(Object::toString).collect(Collectors.joining(",")) +
                ", marketDeck=" + marketDeck +
                ", intrigueDeck=" + intrigueDeck +
                ", gamePhase=" + gamePhase +
                ", gameState=" + gameState +
                ", upkeepPhase=" + upkeepPhase +
                ", intriguePhase=" + intriguePhase +
                ", marketPhase=" + marketPhase +
                ", arenaPhase=" + arenaPhase +
                '}';
    }
}
