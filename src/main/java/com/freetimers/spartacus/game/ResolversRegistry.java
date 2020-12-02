package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.action.ActionType;

import java.util.HashMap;
import java.util.Map;

import static com.freetimers.spartacus.gamebox.action.ActionType.GAIN_INFLUENCE;

public class ResolversRegistry {
    private final Map<ActionType, Resolver> actionResolvers = new HashMap<>();

    public ResolversRegistry() {
        actionResolvers.put(GAIN_INFLUENCE, new GainInfluenceResolver());
    }

    public void resolveAction(Intrigue intrigue) {
        intrigue.getIntrigueCard().getActions().forEach(action -> {
            Resolver actionResolver = actionResolvers.get(action.getActionType());
            if (actionResolver.checkConditions(action, intrigue)) {
                actionResolver.resolveAction(action, intrigue);
            } else {
                throw new IllegalStateException(String.format("Conditions were not met for Action: %s in %s", action, intrigue));
            }
        });
    }
}
