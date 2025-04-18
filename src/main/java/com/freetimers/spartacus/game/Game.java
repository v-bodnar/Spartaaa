package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.*;

import java.util.concurrent.CompletionStage;

public interface Game {
    String getId ();

    boolean connect(String password);

    void selectDominus(DominusBoard dominusBoard, String playersName, String sessionId, boolean gameOwner);

    void resetPlayersSessionId(String playersName, String sessionId);

    int getRound();

    void chooseGladiatorsToRelease(Dominus dominus);

    Dominus getActiveDominus();

    void requestHelp(Dominus source, Dominus target, Intrigue intrigue);

    CompletionStage<Void> playIntrigue (Dominus source, Dominus target, Intrigue intrigue);

    void sellIntrigue (IntrigueCard intrigue);

    void useDominusSkill (Dominus dominus);

    CompletionStage<Void> playReaction(Dominus source, ReactionCard reaction, IntrigueCard intrigue);

    void finishTurn (Dominus dominus);

    CompletionStage<Void> makeOffer (Offer offer);

    void acceptOffer (Offer offer);

    void declineOffer (Offer offer);

    void sellCard(Dominus dominus, Card card);

    void finishTrading(Dominus dominus);

    void makeBet(Dominus source, int goldCoins);

    void prepareNewGame ();
}
