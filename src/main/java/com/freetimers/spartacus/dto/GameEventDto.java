package com.freetimers.spartacus.dto;

import java.util.Objects;

public class GameEventDto {
    private final CoreGameDto coreGame;

    public GameEventDto(CoreGameDto coreGame) {
        this.coreGame = coreGame;
    }

    public CoreGameDto getCoreGame() {
        return coreGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEventDto that = (GameEventDto) o;
        return Objects.equals(coreGame, that.coreGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coreGame);
    }

    @Override
    public String toString() {
        return "GameEventDto{" +
                "coreGame=" + coreGame +
                '}';
    }
}
