package com.freetimers.spartacus.game.event;

import com.freetimers.spartacus.game.CoreGame;
import com.freetimers.spartacus.game.GameService;
import org.springframework.context.ApplicationEvent;

public class PlayerJoinedEvent extends GameEvent {
    public PlayerJoinedEvent(GameService gameService, CoreGame coreGame) {
        super(gameService, coreGame);
    }

    @Override
    public String toString() {
        return "PlayerJoinedEvent{} " + super.toString();
    }
}
