package com.freetimers.spartacus.websocket;

import org.springframework.messaging.rsocket.RSocketRequester;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class Session {
    private final String id;
    private Locale locale;
    private RSocketRequester requester;

    public Session(String id) {
        this.id = id;
        this.locale = Locale.US;
    }

    public String getId() {
        return id;
    }

    public Locale getLocale() {
        return locale;
    }

    public Optional<RSocketRequester> getRequester() {
        return Optional.ofNullable(requester);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setRequester(RSocketRequester requester) {
        this.requester = requester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(locale, session.locale) &&
                Objects.equals(requester, session.requester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, requester);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", locale=" + locale +
                ", requester=" + requester +
                '}';
    }
}
