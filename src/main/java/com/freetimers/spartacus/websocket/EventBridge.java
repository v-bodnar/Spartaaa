package com.freetimers.spartacus.websocket;

import com.freetimers.spartacus.dto.GameEventDto;
import com.freetimers.spartacus.game.GameMapper;
import com.freetimers.spartacus.game.event.GameEvent;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import reactor.core.publisher.FluxSink;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

@Component
class EventBridge implements ApplicationListener<GameEvent>, Consumer<FluxSink<GameEventDto>> {

    private final Executor executor;
    private final LinkedBlockingQueue<GameEvent> queue;
    private final Logger logger;
    private final GameMapper gameMapper;

    @Autowired
    EventBridge(@Qualifier("SingleThreadExecutor") Executor executor, Logger logger, GameMapper gameMapper) {
        this(executor, new LinkedBlockingQueue<>(), logger, gameMapper);
    }

    private EventBridge(Executor executor, LinkedBlockingQueue<GameEvent> queue, Logger logger, GameMapper gameMapper) {
        this.executor = executor;
        this.queue = queue;
        this.logger = logger;
        this.gameMapper = gameMapper;
    }

    @Override
    public void onApplicationEvent(GameEvent event) {
        this.queue.offer(event);
    }

    @Override
    public void accept(FluxSink<GameEventDto> sink) {
        this.executor.execute(() -> {
            while (true)
                try {
                    GameEvent gameEvent = queue.take();
                    GameEventDto event = gameMapper.gameEventToGameEventDto(gameEvent);
                    sink.next(event);
                    logger.debug("Published new game event: {}", event);
                } catch (InterruptedException e) {
                    ReflectionUtils.rethrowRuntimeException(e);
                }
        });
    }
}