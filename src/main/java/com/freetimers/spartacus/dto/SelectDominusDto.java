package com.freetimers.spartacus.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SelectDominusDto {
    private final String gameId;
    private final String dominusBoardId;
    private final String playersName;

    private final boolean gameOwner;

    @JsonCreator
    public SelectDominusDto(@JsonProperty("gameId") String gameId,
                            @JsonProperty("dominusBoardId") String dominusBoardId,
                            @JsonProperty("playersName") String playersName,
                            @JsonProperty("gameOwner") boolean gameOwner) {
        this.gameId = gameId;
        this.dominusBoardId = dominusBoardId;
        this.playersName = playersName;
        this.gameOwner = gameOwner;
    }

    public String getGameId() {
        return gameId;
    }

    public String getDominusBoardId() {
        return dominusBoardId;
    }

    public String getPlayersName() {
        return playersName;
    }

    public boolean isGameOwner() {
        return gameOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectDominusDto that = (SelectDominusDto) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(dominusBoardId, that.dominusBoardId) &&
                Objects.equals(playersName, that.playersName) &&
                gameOwner == that.gameOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, dominusBoardId, playersName, gameOwner);
    }

    @Override
    public String toString() {
        return "SelectDominusDto{" +
                "gameId='" + gameId + '\'' +
                ", dominusBoardId='" + dominusBoardId + '\'' +
                ", playersName='" + playersName + '\'' +
                ", gameOwner=" + gameOwner +
                '}';
    }
}
