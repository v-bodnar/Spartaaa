package com.freetimers.spartacus.websocket;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {

    private final List<Session> sessionList = new LinkedList<>();
    private static final int MAX_SESSION_NUM = 1000;

    public Session createSession(RSocketRequester requester){
        Session session = new Session(UUID.randomUUID().toString());
        session.setRequester(requester);
        sessionList.add(session);
        removeOldestSessionIfMaxExceeds();
        return session;
    }

    private void removeOldestSessionIfMaxExceeds(){
        if (sessionList.size() > MAX_SESSION_NUM){
            sessionList.remove(0);
        }
    }

    public Optional<Session> getSessionById(String id){
        return sessionList.stream().filter(session -> session.getId().equals(id)).findFirst();
    }

    public Optional<Session> getSessionByRequester(RSocketRequester requester){
        return sessionList.stream().filter(session -> session.getRequester().map(requester1 -> requester1.equals(requester))
                .orElse(false)).findFirst();
    }
}
