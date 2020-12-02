package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.action.ActionType;

import java.util.List;

public class Intrigue {
    public List<ActionType> getActionType(){
        return null; //todo getSchemeCard().getActions().stream().map(Action::getActionType)
    }

    public Dominus getSourceDominus(){
        return null;//todo
    }

    public List<Dominus> getTargetDominusList(){
        return null;//todo
    }

    public Dominus getSupportDominus(){
        return null;//todo
    }

    public IntrigueCard getIntrigueCard(){
        return null;//todo
    }
}
