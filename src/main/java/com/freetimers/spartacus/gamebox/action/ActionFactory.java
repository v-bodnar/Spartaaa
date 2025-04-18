package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Card;
import com.freetimers.spartacus.gamebox.DominusBoard;
import com.freetimers.spartacus.gamebox.GladiatorCard;
import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.Phase;
import com.freetimers.spartacus.gamebox.SlaveCard;

import java.security.Guard;

public class ActionFactory {

    public static final Action INFLUENCE_FOR_EXHAUST_GLAD = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            addPhase(Phase.INTRIGUE).
            setCardNum(2).
            setCardType(GladiatorCard.class).
            createAction();

    public static final Action INFLUENCE_FOR_ASSET_EXHAUSTED = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            addPhase(Phase.INTRIGUE).
            setCardNum(3).
            setCardType(Card.class).
            createAction();

    public static final Action INFLUENCE_FOR_READY_GLADIATOR = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            addPhase(Phase.INTRIGUE).
            setCardNum(5).
            setCardType(GladiatorCard.class).
            createAction();

    public static final Action FOIL_SCHEME = Action.getBuilder(ActionType.FOIL_SCHEME).
            createAction();

    public static final Action FOIL_SCHEME_OR_REACTION = Action.getBuilder(ActionType.FOIL_SCHEME_OR_REACTION).
            createAction();

    public static final Action SWITCH_GLADIATOR = Action.getBuilder(ActionType.SWITCH_GLADIATOR).
            addPhase(Phase.ARENA).
            createAction();

    public static final Action GAIN_INFLUENCE = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            createAction();

    public static final Action LOOSE_INFLUENCE = Action.getBuilder(ActionType.LOOSE_INFLUENCE).
            setInfluence(-1).
            createAction();

    public static final Action LOOSE_2_INFLUENCE = Action.getBuilder(ActionType.LOOSE_INFLUENCE).
            setInfluence(-2).
            createAction();

    public static final Action RETRIEVE_GUARD_FROM_DISCARD = Action.getBuilder(ActionType.RETRIEVE_GUARD_FROM_DISCARD).
            createAction();

    public static final Action DISCARD_SLAVE = Action.getBuilder(ActionType.DISCARD_SLAVE).
            createAction();

    public static final Action PAY_DOMINUS_TO_FAIL_SCHEME = Action.getBuilder(ActionType.FOIL_SCHEME).
            setGold(-3).
            createAction();

    public static final Action LOOSE_INFLUENCE_IF_NO_READY_SLAVES = Action.getBuilder(ActionType.LOOSE_INFLUENCE).
            setInfluence(-1).
            setCardType(SlaveCard.class).
            createAction();

    public static final Action LOOSE_INFLUENCE_IF_NO_GOLD = Action.getBuilder(ActionType.LOOSE_INFLUENCE).
            setInfluence(-1).
            addPhase(Phase.INTRIGUE, Phase.ARENA).
            createAction();

    public static final Action LOOSE_INFLUENCE_IF_NO_READY_GLADIATORS = Action.getBuilder(ActionType.LOOSE_INFLUENCE).
            setInfluence(-1).
            addPhase(Phase.INTRIGUE, Phase.MARKET).
            createAction();

    //Scheme actions
    public static final Action GAIN_5_GOLD = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(5).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action DISCARD_READY_GLADIATOR = Action.getBuilder(ActionType.DISCARD_CARD).
            setCardType(GladiatorCard.class).//state ready
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action DRAW_2_CARDS = Action.getBuilder(ActionType.DRAW_CARD).
            setCardNum(2).
            setCardType(IntrigueCard.class).
            addPhase(Phase.INTRIGUE).
            createAction();


    public static final Action INFLUENCE_TO_TARGET = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action INFLUENCE_TO_TWO_PLAYERS = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action DISCARD_READY_SLAVE = Action.getBuilder(ActionType.DISCARD_CARD).
            setCardType(SlaveCard.class).//state ready
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action PAY_2_GOLD_TO_EVERYONE = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(2).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action LOOSE_3_GOLD = Action.getBuilder(ActionType.LOOSE_GOLD).
            setGold(-3).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action INFLUENCE_IF_READY_GLADIATORS = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(1).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action GOLD_PER_READY_SLAVE = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(1).
            setCardType(SlaveCard.class).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action GOLD_2_PER_READY_SLAVE = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(2).
            setCardType(SlaveCard.class).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action LOOSE_5_GOLD = Action.getBuilder(ActionType.LOOSE_GOLD).
            setGold(-5).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action DISCARD_SLAVE_GAIN_VALUE_TWICE = Action.getBuilder(ActionType.DISCARD_SLAVE).
            setCardType(SlaveCard.class).// gain gold
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action GAIN_3_GOLD = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(3).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action EXHAUST_ALL_GUARDS_PAY_PER = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(1).
            setCardType(SlaveCard.class).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action GAIN_INFLUENCE_FOR_WEAKEST = Action.getBuilder(ActionType.GAIN_INFLUENCE).
            setInfluence(2).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action LOSE_2_INFLUENCE_OTHER_LOSES_1 = Action.getBuilder(ActionType.LOOSE_INFLUENCE).
            setInfluence(-2).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action INJURE_ASSET = Action.getBuilder(ActionType.INJURE_ASSET).
            setCardType(GladiatorCard.class).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action GAIN_7_GOLD = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(7).
            addPhase(Phase.INTRIGUE).
            createAction();

    //Slaves
    public static final Action HEALER_REROLL = Action.getBuilder(ActionType.HEALER_REROLL).
            addPhase(Phase.UPKEEP).
            createAction();

    public static final Action SPY_LOOK_RANDOM_CARD = Action.getBuilder(ActionType.SHOW_CARD).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action INFORMANT_LOOK_CARD = Action.getBuilder(ActionType.SHOW_CARD).
            addPhase(Phase.MARKET).
            createAction();

    public static final Action SKILLED_GAIN_GOLD = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(1).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action HANDMAID_DISCARD_AND_DRAW = Action.getBuilder(ActionType.DISCARD_CARD).
            setCardType(IntrigueCard.class).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action BODYGUARD_REROLL_GUARD_ATTEMPT = Action.getBuilder(ActionType.GUARD_REROLL).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action EXCEPTIONAL_GAIN_GOLD = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(2).
            addPhase(Phase.INTRIGUE).
            createAction();

    public static final Action CHASTE_TWO_SLAVES = Action.getBuilder(ActionType.GAIN_GOLD).
            setGold(1).
            addPhase(Phase.UPKEEP).
            createAction();
}
