package com.freetimers.spartacus.dto;

import com.freetimers.spartacus.game.Phase;
import com.freetimers.spartacus.game.*;
import com.freetimers.spartacus.gamebox.*;

import javax.swing.plaf.nimbus.State;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class CoreGameDto {

    private final Instant startTime;
    private final Instant finishedTime;
    private final List<DominusDto> listDominus;
    private final Deck<MarketCard> marketDeck;
    private final Deck<IntrigueCard> intrigueDeck;
    private final Phase gamePhase;
    private final State gameState;
    private final List<UpkeepPhase> upkeepPhase;
    private final List<IntriguePhase> intriguePhase;
    private final List<MarketPhase> marketPhase;
    private final List<ArenaPhase> arenaPhase;


    public CoreGameDto(Instant startTime, Instant finishedTime, List<DominusDto> listDominus,
                       Deck<MarketCard> marketDeck, Deck<IntrigueCard> intrigueDeck, Phase gamePhase,
                       State gameState, List<UpkeepPhase> upkeepPhase, List<IntriguePhase> intriguePhase,
                       List<MarketPhase> marketPhase, List<ArenaPhase> arenaPhase) {
        this.startTime = startTime;
        this.finishedTime = finishedTime;
        this.listDominus = listDominus;
        this.marketDeck = marketDeck;
        this.intrigueDeck = intrigueDeck;
        this.gamePhase = gamePhase;
        this.gameState = gameState;
        this.upkeepPhase = upkeepPhase;
        this.intriguePhase = intriguePhase;
        this.marketPhase = marketPhase;
        this.arenaPhase = arenaPhase;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getFinishedTime() {
        return finishedTime;
    }

    public List<DominusDto> getListDominus() {
        return listDominus;
    }

    public Deck<MarketCard> getMarketDeck() {
        return marketDeck;
    }

    public Deck<IntrigueCard> getIntrigueDeck() {
        return intrigueDeck;
    }

    public Phase getGamePhase() {
        return gamePhase;
    }

    public State getGameState() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreGameDto that = (CoreGameDto) o;
        return Objects.equals(startTime, that.startTime) &&
                Objects.equals(finishedTime, that.finishedTime) &&
                Objects.equals(listDominus, that.listDominus) &&
                Objects.equals(marketDeck, that.marketDeck) &&
                Objects.equals(intrigueDeck, that.intrigueDeck) &&
                gamePhase == that.gamePhase &&
                Objects.equals(gameState, that.gameState) &&
                Objects.equals(upkeepPhase, that.upkeepPhase) &&
                Objects.equals(intriguePhase, that.intriguePhase) &&
                Objects.equals(marketPhase, that.marketPhase) &&
                Objects.equals(arenaPhase, that.arenaPhase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, finishedTime, listDominus, marketDeck, intrigueDeck, gamePhase, gameState,
                upkeepPhase, intriguePhase, marketPhase, arenaPhase);
    }

    @Override
    public String toString() {
        return "CoreGameDto{" +
                "startTime=" + startTime +
                ", finishedTime=" + finishedTime +
                ", listDominus=" + listDominus +
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
