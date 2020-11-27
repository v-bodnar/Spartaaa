package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Action;

public class SwitchGladiatorAction implements Action {

    private static final SwitchGladiatorAction INSTANCE = new SwitchGladiatorAction();
    public SwitchGladiatorAction() {
    }
    public static SwitchGladiatorAction getInstance(){
        return INSTANCE;
    }
}
