package com.freetimers.spartacus.websocket;

public enum ProcessState {
    CREATED(false),
    VERIFIED(false),
    AUTHORIZATION_PENDING(false),
    AUTHORIZED(false),
    ACTIVE(true);

        private final boolean terminalState;

    ProcessState(boolean terminalState) {
        this.terminalState = terminalState;
    }

    public boolean isTerminalState() {
        return terminalState;
    }
}
