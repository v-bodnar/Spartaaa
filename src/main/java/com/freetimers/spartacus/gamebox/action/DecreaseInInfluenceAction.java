package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Action;

public class DecreaseInInfluenceAction implements Action{
    private static final DecreaseInInfluenceAction INSTANCE = new DecreaseInInfluenceAction();

    public static DecreaseInInfluenceAction getINSTANCE() {return INSTANCE;}
}
