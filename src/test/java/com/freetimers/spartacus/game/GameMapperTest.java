package com.freetimers.spartacus.game;


import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.gamebox.Deck;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameMapperTest {

    @Test
    public void mapperTest() {
        //given
        GameMapper gameMapper = Mappers.getMapper(GameMapper.class);
        CoreGame coregame = new CoreGame(new Deck<>(), new Deck<>());

        //when
        CoreGameDto coreGameDto = gameMapper.gameToGameDto(coregame);

        //then
        assertNotNull(coreGameDto);
        assertEquals(Phase.LOBBY, coreGameDto.getGamePhase());
        assertEquals(GameState.NEW, coreGameDto.getGameState());
    }
}
