package com.freetimers.spartacus.game;


import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.gamebox.Deck;
import com.freetimers.spartacus.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);
    private GameService gameService;
    private GameRepository gameRepositoryMock;
    private EquipmentCardsRepo equipmentCardsRepoMock;
    private GladiatorCardsRepo gladiatorCardsRepoMock;
    private ReactionCardsRepo reactionCardsRepoMock;
    private SchemeCardsRepo schemeCardsRepoMock;
    private SlaveCardsRepo slaveCardsRepoMock;
    private DominusBoardRepo dominusBoardRepoMock;
    private ApplicationEventPublisher applicationEventPublisherMock;
    private GameMapper gameMapperMock;

    @BeforeEach
    public void setUp() {
        gameRepositoryMock = mock(GameRepository.class);
        equipmentCardsRepoMock = mock(EquipmentCardsRepo.class);
        gladiatorCardsRepoMock = mock(GladiatorCardsRepo.class);
        reactionCardsRepoMock = mock(ReactionCardsRepo.class);
        schemeCardsRepoMock = mock(SchemeCardsRepo.class);
        slaveCardsRepoMock = mock(SlaveCardsRepo.class);
        dominusBoardRepoMock = mock(DominusBoardRepo.class);
        applicationEventPublisherMock = mock(ApplicationEventPublisher.class);
        gameMapperMock = mock(GameMapper.class);
        gameService = new GameService(LOGGER,
                gameRepositoryMock,
                equipmentCardsRepoMock,
                gladiatorCardsRepoMock,
                reactionCardsRepoMock,
                schemeCardsRepoMock,
                slaveCardsRepoMock,
                dominusBoardRepoMock,
                applicationEventPublisherMock);
    }

    @Test
    public void createNewGameTest() {
        //given
        CoreGame coreGame = new CoreGame(new Deck<>(), new Deck<>());
        CoreGameDto coreGameDto = new CoreGameDto(null, null, null, null, null,
                null, null, null, null, null, null);
        when(gameRepositoryMock.save(any(CoreGame.class))).thenReturn(coreGame);
        when(equipmentCardsRepoMock.findAll()).thenReturn(new LinkedList<>());
        when(gladiatorCardsRepoMock.findAll()).thenReturn(new LinkedList<>());
        when(reactionCardsRepoMock.findAll()).thenReturn(new LinkedList<>());
        when(schemeCardsRepoMock.findAll()).thenReturn(new LinkedList<>());
        when(slaveCardsRepoMock.findAll()).thenReturn(new LinkedList<>());

        //when
        CoreGame newGame = gameService.createNewCoreGame();

        //then
        assertNotNull(newGame);
    }
}
