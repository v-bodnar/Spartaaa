package com.freetimers.spartacus.game.event;

import com.freetimers.spartacus.game.CoreGame;

public class DominusSelectedEvent extends GameEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source   the object on which the event initially occurred or with
     *                 which the event is associated (never {@code null})
     * @param coreGame
     */
    public DominusSelectedEvent(Object source, CoreGame coreGame) {
        super(source, coreGame);
    }

    @Override
    public String toString() {
        return "DominusSelectedEvent{} " + super.toString();
    }
}
