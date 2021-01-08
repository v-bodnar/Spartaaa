package com.freetimers.spartacus.websocket;

import com.freetimers.spartacus.game.event.GameEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.UUID.randomUUID;

@Component
class EventBridge {

        private static class Subscriber {
        private final UUID sessionId;
        private final FluxSink<ProcessState> sink;
        private boolean eventEmitted;
    }

    private final Map<UUID, Subscriber> subscribers = new ConcurrentHashMap<>();

    @EventListener
    void stateChanged(GameEvent event) {
        notifySubscribers(event);
    }

    Flux<ProcessState> register(UUID userId) {
        return Flux.push(emitter -> addSubscriber(userId, emitter));
    }

    private Subscriber addSubscriber(UUID userId, FluxSink<ProcessState> sink) {
        var subscriptionId = randomUUID();
        var subscriber = new Subscriber(userId, sink);
        subscribers.put(subscriptionId, subscriber);
        sink
                .onRequest(n -> poll(subscriber))
                .onDispose(() -> removeSubscriber(subscriptionId));
        return subscriber;
    }

    private void poll(Subscriber subscriber) {
        emit(subscriber, loadCurrentState(subscriber), true);
    }

    private ProcessState loadCurrentState(Subscriber subscriber) {
        return repository.findById(subscriber.sessionId).getProcessState();
    }

    private void removeSubscriber(UUID subscriptionId) {
        subscribers.remove(subscriptionId);
    }

    private void notifySubscribers(GameEvent event) {
        subscribers.values().stream()
                .filter(subscriber -> subscriber.sessionId.equals(event.getUserId()))
                .forEach(subscriber -> emit(subscriber, event.getNewState(), false));
    }

    private void emit(Subscriber subscriber, ProcessState processState, boolean onlyIfFirst) {
        synchronized (subscriber) {
            if (onlyIfFirst && subscriber.eventEmitted) {
                return;
            }
            subscriber.sink.next(processState);
            if (processState.isTerminalState()) {
                subscriber.sink.complete();
            }
            subscriber.eventEmitted = true;
        }
    }

}