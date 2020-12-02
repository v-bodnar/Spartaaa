package com.freetimers.spartacus.gamebox.action;

import java.util.Objects;

public class InfluenceForPeoplesAction implements Action{

    private static final InfluenceForPeoplesAction INSTANCE = new InfluenceForPeoplesAction();

    private InfluenceForPeoplesAction() {}

    public static InfluenceForPeoplesAction getInstance() { return INSTANCE; }

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
