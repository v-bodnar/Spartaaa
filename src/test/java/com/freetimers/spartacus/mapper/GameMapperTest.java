package com.freetimers.spartacus.mapper;


import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.game.CoreGame;
import com.freetimers.spartacus.game.GameState;
import com.freetimers.spartacus.game.Phase;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameMapperTest {

    private GameMapper gameMapper = Mappers.getMapper(GameMapper.class);

    @Test
    public void gameToGameDtoTest() {
        //when
        CoreGameDto coreGameDto = gameMapper.gameToGameDto(new CoreGame());

        //then
        assertNotNull(coreGameDto);
        assertEquals(Phase.LOBBY, coreGameDto.getGamePhase());
        assertEquals(GameState.NEW, coreGameDto.getGameState());
    }
}
