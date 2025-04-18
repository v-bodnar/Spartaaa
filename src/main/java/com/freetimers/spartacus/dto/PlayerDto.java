package com.freetimers.spartacus.dto;

import java.util.Objects;

public class PlayerDto {
    private final String name;
    private final String sessionToken;
    private final String avatar;
    private final boolean gameOwner;
    public PlayerDto(String name, String sessionToken, String avatar, boolean gameOwner) {
        this.name = name;
        this.sessionToken = sessionToken;
        this.avatar = avatar;
        this.gameOwner = gameOwner;
    }

    public String getName() {
        return name;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isGameOwner() {
        return gameOwner;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto playerDto = (PlayerDto) o;
        return Objects.equals(name, playerDto.name) &&
                Objects.equals(sessionToken, playerDto.sessionToken) &&
                Objects.equals(avatar, playerDto.avatar)
                && gameOwner == playerDto.gameOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sessionToken, avatar, gameOwner);
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "name='" + name + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gameOwner=" + gameOwner +
                '}';
    }
}
