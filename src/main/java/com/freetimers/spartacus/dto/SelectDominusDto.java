package com.freetimers.spartacus.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SelectDominusDto {
    private final String gameId;
    private final String dominusBoardId;
    private final String playersName;

    @JsonCreator
    public SelectDominusDto(@JsonProperty("gameId") String gameId,
                            @JsonProperty("dominusBoardId") String dominusBoardId,
                            @JsonProperty("playersName") String playersName) {
        this.gameId = gameId;
        this.dominusBoardId = dominusBoardId;
        this.playersName = playersName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectDominusDto that = (SelectDominusDto) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(dominusBoardId, that.dominusBoardId) &&
                Objects.equals(playersName, that.playersName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, dominusBoardId, playersName);
    }

    @Override
    public String toString() {
        return "SelectDominusDto{" +
                "gameId='" + gameId + '\'' +
                ", dominusBoardId='" + dominusBoardId + '\'' +
                ", playersName='" + playersName + '\'' +
                '}';
    }
}
