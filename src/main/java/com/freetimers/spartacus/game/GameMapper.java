package com.freetimers.spartacus.game;

import com.freetimers.spartacus.dto.*;
import com.freetimers.spartacus.gamebox.IntrigueCard;
import com.freetimers.spartacus.gamebox.MarketCard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {

    CoreGameDto gameToGameDto(CoreGame coreGame);

    DominusDto dominusToDominusDto(Dominus dominus);

    IntrigueCardDto intrigueCardToIntrigueCardDto(IntrigueCard intrigueCard);

    MarketCardDto marketCardToMarketCardDto(MarketCard marketCard);

    ArenaPhaseDto arenaPhaseToArenaPhaseDto(ArenaPhase arenaPhase);

    IntriguePhaseDto intriguePhaseToIntriguePhaseDto(IntriguePhase intriguePhase);

    UpkeepPhaseDto upkeepPhaseToUpkeepPhaseDto(UpkeepPhase upkeepPhase);

    MarketPhaseDto marketPhaseToMarketPhaseDto(MarketPhase marketPhase);
}
