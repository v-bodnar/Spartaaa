package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Card;
import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Phase;

public class ActionFactory {
    public static final Action INFLUENCE_FOR_EXHAUST_GLAD = Action.getBuilder(ActionType.INFLUENCE_FOR_EXHAUST_GLAD).
            setInfluence(1).
            setPhase(Phase.INTRIGUE).
            setCardNum(2).
            setCardType(GladiatorCard.class).
            createAction();

    public static final Action INFLUENCE_FOR_ASSET_EXHAUSTED = Action.getBuilder(ActionType.INFLUENCE_FOR_ASSET_EXHAUSTED).
            setInfluence(1).
            setPhase(Phase.INTRIGUE).
            setCardNum(3).
            setCardType(Card.class).
            createAction();

    public static final Action INFLUENCE_FOR_READY_GLADIATOR = Action.getBuilder(ActionType.INFLUENCE_FOR_READY_GLADIATOR).
            setInfluence(0).
            setPhase(Phase.INTRIGUE).
            setCardNum(5).
            setCardType(GladiatorCard.class).
            createAction();

    public static final Action FAIL_SCHEME = Action.getBuilder(ActionType.FAIL_SCHEME).
            setInfluence(8).
            setPhase(Phase.INTRIGUE).
            setCardNum(1).
            setCardType(IntrigueCard.class).
            createAction();

    public static final Action SWITCH_GLADIATOR = Action.getBuilder(ActionType.SWITCH_GLADIATOR).
            setInfluence(0).
            setPhase(Phase.ARENA).
            createAction();

    public static final Action DECREASE_INFLUENCE_GLAD = Action.getBuilder(ActionType.DECREASE_INFLUENCE_GLAD).
            setInfluence(0).
            setPhase(Phase.INTRIGUE).///todo конкретно тут ввсе фазы кроме арены
            createAction();
}
