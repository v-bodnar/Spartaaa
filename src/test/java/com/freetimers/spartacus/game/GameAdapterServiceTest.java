package com.freetimers.spartacus.game;


import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.mapper.GameMapper;
import com.freetimers.spartacus.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameAdapterServiceTest {

    private GameAdapterService gameAdapterService;
    private GameRepository gameRepositoryMock;
    private ApplicationEventPublisher applicationEventPublisherMock;
    private GameMapper gameMapperMock;

    @Before
    public void setUp(){
        gameRepositoryMock = mock(GameRepository.class);
        applicationEventPublisherMock = mock(ApplicationEventPublisher.class);
        gameMapperMock = mock(GameMapper.class);
        gameAdapterService = new GameAdapterService(gameRepositoryMock, applicationEventPublisherMock, gameMapperMock);
    }

    @Test
    public void createNewGameTest(){
    //given
        ArgumentCaptor<CoreGame> gameCaptor = ArgumentCaptor.forClass(CoreGame.class);
    when(gameRepositoryMock.save(any())).thenReturn(new CoreGame());
    when(gameMapperMock.gameToGameDto(any())).thenReturn(new CoreGameDto(null,null,null,
            null,null,null,null, null, null,
            null, null));

    //when
        CoreGameDto newGame = gameAdapterService.createNewGame();

    //then
    assertNotNull(newGame);
    }
}
