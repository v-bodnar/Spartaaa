package com.freetimers.spartacus.game;

import com.freetimers.spartacus.dto.CoreGameDto;
import com.freetimers.spartacus.mapper.GameMapper;
import com.freetimers.spartacus.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class GameAdapterService {

    private final GameRepository gameRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final GameMapper gameMapper;

@Autowired
    public GameAdapterService(GameRepository gameRepository, ApplicationEventPublisher applicationEventPublisher,
                              GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.gameMapper = gameMapper;
    }

    public CoreGameDto createNewGame(){
    CoreGame newGame = new CoreGame ();
    newGame.prepareNewGame();
    newGame = gameRepository.save(newGame);
    return gameMapper.gameToGameDto(newGame);
    }

}
