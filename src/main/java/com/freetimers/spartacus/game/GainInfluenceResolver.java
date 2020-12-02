package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.action.Action;

public class GainInfluenceResolver implements Resolver {

    @Override
    public boolean checkConditions(Action action, Intrigue intrigue) {
        return new RequiredInfluencePredicate().test(intrigue);
    }

    @Override
    public void resolveAction(Action action, Intrigue intrigue) {
        intrigue.getTargetDominusList().forEach(dominus -> dominus.changeInfluence(action.getInfluence().orElse(0)));
    }

}
