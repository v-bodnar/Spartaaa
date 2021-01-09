package com.freetimers.spartacus.dto;

import com.freetimers.spartacus.game.GameState;
import com.freetimers.spartacus.game.Phase;

import java.time.Instant;
import java.util.List;

public class CoreGameDto {
    private final String id;
    private final String password;
    private final Instant startTime;
    private final Instant finishedTime;
    private final List<DominusDto> dominusList;
    private final Phase gamePhase;
    private final GameState gameState;
    private final List<UpkeepPhaseDto> upkeepPhase;
    private final List<IntriguePhaseDto> intriguePhase;
    private final List<MarketPhaseDto> marketPhase;
    private final List<ArenaPhaseDto> arenaPhase;


    public CoreGameDto(String id, String password, Instant startTime, Instant finishedTime, List<DominusDto> dominusList,
                       Phase gamePhase, GameState gameState, List<UpkeepPhaseDto> upkeepPhase,
                       List<IntriguePhaseDto> intriguePhase, List<MarketPhaseDto> marketPhase,
                       List<ArenaPhaseDto> arenaPhase) {
        this.id = id;
        this.password = password;
        this.startTime = startTime;
        this.finishedTime = finishedTime;
        this.dominusList = dominusList;
        this.gamePhase = gamePhase;
        this.gameState = gameState;
        this.upkeepPhase = upkeepPhase;
        this.intriguePhase = intriguePhase;
        this.marketPhase = marketPhase;
        this.arenaPhase = arenaPhase;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getFinishedTime() {
        return finishedTime;
    }

    public List<DominusDto> getDominusList() {
        return dominusList;
    }

    public Phase getGamePhase() {
        return gamePhase;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<UpkeepPhaseDto> getUpkeepPhase() {
        return upkeepPhase;
    }

    public List<IntriguePhaseDto> getIntriguePhase() {
        return intriguePhase;
    }

    public List<MarketPhaseDto> getMarketPhase() {
        return marketPhase;
    }

    public List<ArenaPhaseDto> getArenaPhase() {
        return arenaPhase;
    }

    @Override
    public String toString() {
        return "CoreGameDto{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", startTime=" + startTime +
                ", finishedTime=" + finishedTime +
                ", dominusList=" + dominusList +
                ", gamePhase=" + gamePhase +
                ", gameState=" + gameState +
                ", upkeepPhase=" + upkeepPhase +
                ", intriguePhase=" + intriguePhase +
                ", marketPhase=" + marketPhase +
                ", arenaPhase=" + arenaPhase +
                '}';
    }
}
