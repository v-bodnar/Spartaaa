package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.ReactionCard;
import com.freetimers.spartacus.gamebox.SchemeCard;

import java.util.*;

public class Intrigue {

    private IntrigueState intrigueState;
    private final Dominus source;
    private final Dominus support;
    private final List<Dominus> target;
    private final SchemeCard schemeCard;
    private final List<ReactionCard> reactions;

    private Intrigue(IntrigueState intrigueState, Dominus source, Dominus support, List<Dominus> target,
                    SchemeCard schemeCard, List<ReactionCard> reactions) {
        this.intrigueState = intrigueState;
        this.source = source;
        this.support = support;
        this.target = target;
        this.schemeCard = schemeCard;
        this.reactions = reactions;
    }

    static Intrigue of(Dominus source, SchemeCard schemeCard, Dominus...targets) {
        return new Intrigue(IntrigueState.ACTIVE, source, null, Arrays.asList(targets), schemeCard,
                new LinkedList<>());
    }

    static Intrigue of(Dominus source, ReactionCard reactionCard, Dominus...targets) {
        return new Intrigue(IntrigueState.ACTIVE, source, null, Arrays.asList(targets), null,
                new LinkedList<>(Collections.singletonList(reactionCard)));
    }

    static Intrigue of(Dominus source, Dominus support, SchemeCard schemeCard, Dominus...targets) {
        return new Intrigue(IntrigueState.ACTIVE, source, support, Arrays.asList(targets), schemeCard,
                new LinkedList<>());
    }

    public void setIntrigueState(IntrigueState intrigueState) {
        this.intrigueState = intrigueState;
    }

    public Dominus getSourceDominus(){return source;}

    public List<Dominus> getTargetDominusList(){return target;}

    public Optional<Dominus> getSupportDominus(){ return Optional.ofNullable(support); }

    public IntrigueCard getIntrigueCard(){
        return Optional.ofNullable(schemeCard).map(schemeCard1 -> (IntrigueCard) schemeCard1).orElse(reactions.get(0));
    }

    public IntrigueState getIntrigueState() {
        return intrigueState;
    }

    public List<ReactionCard> getReactions() {
        return reactions;
    }
}
