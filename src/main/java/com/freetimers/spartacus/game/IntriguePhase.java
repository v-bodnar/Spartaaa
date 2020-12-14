package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.IntrigueCard;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class IntriguePhase {

    private List<Intrigue> intrigueList;
    private Set<Dominus> dominusTurnOrder;
    private final Duration intrigueTimeOut;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public IntriguePhase(Duration intrigueTimeOut) {
        this.intrigueTimeOut = intrigueTimeOut;
    }


    Dominus getActiveDominus(){
        return dominusTurnOrder.iterator().next();
}

boolean isDominusActive(Dominus dominus){
    return getActiveDominus().equals(dominus);
}

void requestHelp (Intrigue intrigue) {};

CompletionStage<Void> playIntrigue (Intrigue intrigue){ return null;};

void sellIntrigue (IntrigueCard intrigue){};

void useDominusSkill(Dominus dominus){};

void playReaction(Intrigue intrigue){};

void finishTurn(Dominus dominus){};
}
