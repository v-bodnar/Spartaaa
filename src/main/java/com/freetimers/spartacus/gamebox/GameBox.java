package com.freetimers.spartacus.gamebox;

import java.util.List;

public interface GameBox {
    public List<IntrigueCard> getIntrigueCards();
    public List<MarketCard> getMarketCards();
    public List<DominusBoard> getDominusBoards();
}
