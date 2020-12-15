package com.freetimers.spartacus.game;

import com.freetimers.spartacus.gamebox.MarketCard;

import java.util.List;
import java.util.Map;

public class MarketPhase {

    private List<MarketCard> auction;
    private MarketCard revealedMarketCard;
    private Map<Dominus, MarketCard> completedTrades;
    private List<Offer> offersMade;
    private Map<Dominus, Integer> stash;

    Offer makeOffer(Offer offer){
        return null;}

    void acceptOffer(Offer offer){}

    void declineOffer(Offer offer){}

    void finishTrading(Dominus dominus){}

    void makeBet(Dominus source, Integer goldCoins){}


}
