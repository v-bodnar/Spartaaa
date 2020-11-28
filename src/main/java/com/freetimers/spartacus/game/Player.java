package com.freetimers.spartacus.game;

import java.util.Objects;

 class Player {
    private final String name;
    private final String sessionToken;
    private final String avatar;

    public Player(String name, String sessionToken, String avatar) {
        this.name = name;
        this.sessionToken = sessionToken;
        this.avatar = avatar;
    }

    String getName() {
        return name;
    }

    String getSessionToken() {
        return sessionToken;
    }

    String getAvatar() {
        return avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(sessionToken, player.sessionToken) &&
                Objects.equals(avatar, player.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sessionToken, avatar);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sesionToken='" + sessionToken + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
