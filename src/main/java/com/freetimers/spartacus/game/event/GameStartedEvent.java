package com.freetimers.spartacus.game.event;

import com.freetimers.spartacus.game.CoreGame;
import com.freetimers.spartacus.game.GameService;
import org.springframework.context.ApplicationEvent;

public class GameStartedEvent extends GameEvent {
    public GameStartedEvent(GameService gameService, CoreGame coreGame) {
        super(gameService, coreGame);
    }

    @Override
    public String toString() {
        return "GameStartedEvent{} " + super.toString();
    }
}
