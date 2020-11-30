package com.freetimers.spartacus.gamebox.action;

import java.util.Objects;

public class StartingGladiators implements Action{

    private static final StartingGladiators INSTANCE = new StartingGladiators();

    private StartingGladiators() {
    }

    public static StartingGladiators getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
