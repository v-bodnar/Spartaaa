package com.freetimers.spartacus.websocket.dto;

public class JoinGameRequest {
    private String playerName;
    private String gameId;
    private String gamePassword;

    public String getGameId() {
        return gameId;
    }

    public String getGamePassword() {
        return gamePassword;
    }

    public String getPlayerName() {
        return playerName;
    }
}
