package com.freetimers.spartacus.game.event;

import com.freetimers.spartacus.game.CoreGame;
import org.springframework.context.ApplicationEvent;

public abstract class GameEvent extends ApplicationEvent {

    private final CoreGame coreGame;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     * @param coreGame
     */
    public GameEvent(Object source, CoreGame coreGame) {
        super(source);
        this.coreGame = coreGame;
    }

    public CoreGame getCoreGame() {
        return coreGame;
    }


}
