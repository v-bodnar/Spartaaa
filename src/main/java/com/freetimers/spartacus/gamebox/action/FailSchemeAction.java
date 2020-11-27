package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Action;

public class FailSchemeAction implements Action {
    private static final FailSchemeAction INSTANCE = new FailSchemeAction();

    public static FailSchemeAction getINSTANCE() { return INSTANCE; }
}
