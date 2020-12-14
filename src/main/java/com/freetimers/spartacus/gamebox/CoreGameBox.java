package com.freetimers.spartacus.gamebox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoreGameBox implements GameBox {

    @Override
    public List<IntrigueCard> getIntrigueCards() {return Collections.emptyList(); }

    @Override
    public List<MarketCard> getMarketCards() { return Collections.emptyList(); }

    @Override
    public List<DominusBoard> getDominusBoards() {  return Collections.emptyList();
    }
}
