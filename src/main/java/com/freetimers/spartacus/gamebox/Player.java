package com.freetimers.spartacus.gamebox;

import java.util.Objects;

 class Player {
    private final String name;
    private final String sesionToken;
    private final String avatar;

    public Player(String name, String sessionToken, String avatar) {
        this.name = name;
        this.sesionToken = sessionToken;
        this.avatar = avatar;
    }

    String getName() {
        return name;
    }

    String getSessionToken() {
        return sesionToken;
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
                Objects.equals(sesionToken, player.sesionToken) &&
                Objects.equals(avatar, player.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sesionToken, avatar);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sesionToken='" + sesionToken + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
