package com.freetimers.spartacus.game;

import com.freetimers.spartacus.dto.*;
import com.freetimers.spartacus.game.event.GameEvent;
import com.freetimers.spartacus.gamebox.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface GameMapper {

    CoreGameDto gameToGameDto(CoreGame coreGame);

    PlayerDto playerToPlayerDto(Player player);

    DominusDto dominusToDominusDto(Dominus dominus);

    @Mapping(source = "id", target = "id", qualifiedByName = "unwrap")
    @Mapping(source = "title", target = "title", qualifiedByName = "unwrap")
    @Mapping(source = "description", target = "description", qualifiedByName = "unwrap")
    DominusBoardDto dominusBoardToDominusBoardDto(DominusBoard dominusboard);

    IntrigueCardDto intrigueCardToIntrigueCardDto(IntrigueCard intrigueCard);

    MarketCardDto marketCardToMarketCardDto(MarketCard marketCard);

    ArenaPhaseDto arenaPhaseToArenaPhaseDto(ArenaPhase arenaPhase);

    IntriguePhaseDto intriguePhaseToIntriguePhaseDto(IntriguePhase intriguePhase);

    UpkeepPhaseDto upkeepPhaseToUpkeepPhaseDto(UpkeepPhase upkeepPhase);

    MarketPhaseDto marketPhaseToMarketPhaseDto(MarketPhase marketPhase);

    GladiatorCardDto gladiatorCardToGladiatorCardDto(GladiatorCard gladiatorCard);

    SlaveCardDto slaveCardToSlaveCardDto(SlaveCard slaveCard);

    GuardCardDto guardCardToGuardCardDto(GuardCard guardCard);

    EquipmentCardDto equipmentCardToEquipmentCardDto(EquipmentCard equipmentCard);

    GameEventDto gameEventToGameEventDto(GameEvent gameEvent);


    @Named("unwrap")
    default <T> T unwrap(Optional<T> optional) {
        return optional.orElse(null);
    }
}
