package com.freetimers.spartacus.game;

import java.util.Objects;

 class Player {
    private final String name;
    private final String sessionToken;
    private final String avatar;

    private final boolean gameOwner;

    public Player(String name, String sessionToken, String avatar, boolean gameOwner) {
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
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(sessionToken, player.sessionToken) &&
                Objects.equals(avatar, player.avatar)
                && gameOwner == player.gameOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sessionToken, avatar, gameOwner);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sesionToken='" + sessionToken + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gameOwner=" + gameOwner +
                '}';
    }
}
