package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.action.Action;

public interface Resolver {
    boolean checkConditions(Action action, Intrigue intrigue);
    void resolveAction(Action action, Intrigue intrigue);
}
