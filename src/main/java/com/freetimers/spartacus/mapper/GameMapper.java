package com.freetimers.spartacus.mapper;

import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.game.CoreGame;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GameMapper {

CoreGameDto gameToGameDto(CoreGame coreGame);
    
}
