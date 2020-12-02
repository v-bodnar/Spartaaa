package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Card;
import com.freetimers.spartacus.gamebox.Phase;

import java.util.Objects;
import java.util.Optional;

public class Action {
    private final ActionType actionType;
    private final Integer influence;
    private final Integer gold;
    private final Integer cardNum;
    private final Class<? extends Card> cardType;
    private final Phase phase;

    public Action(ActionType actionType, Integer influence, Integer gold, Integer cardNum, Class<? extends Card> cardType, Phase phase) {
        this.actionType = Objects.requireNonNull(actionType);
        this.influence = influence;
        this.gold = gold;
        this.cardNum = cardNum;
        this.cardType = cardType;
        this.phase = phase;
    }

    public static ActionBuilder getBuilder(ActionType actionType){
        return new ActionBuilder(actionType);
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Optional<Integer> getInfluence() {
        return Optional.ofNullable(influence);
    }

    public Optional<Integer> getGold() {
        return Optional.ofNullable(gold);
    }

    public Optional<Integer> getCardNum() {
        return Optional.ofNullable(cardNum);
    }

    public Optional<Class<? extends Card>> getCardType() {
        return Optional.ofNullable(cardType);
    }

    public Optional<Phase> getPhase() {
        return Optional.ofNullable(phase);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(influence, action.influence) &&
                Objects.equals(gold, action.gold) &&
                Objects.equals(cardNum, action.cardNum) &&
                Objects.equals(cardType, action.cardType) &&
                phase == action.phase;
    }

    @Override
    public int hashCode() {
        return Objects.hash(influence, gold, cardNum, cardType, phase);
    }

    @Override
    public String toString() {
        return "Action{" +
                "influence=" + influence +
                ", gold=" + gold +
                ", cardNum=" + cardNum +
                ", cardType=" + cardType +
                ", phase=" + phase +
                '}';
    }

    public static class ActionBuilder {
        private final ActionType actionType;
        private Integer influence;
        private Integer gold;
        private Integer cardNum;
        private Class<? extends Card> cardType;
        private Phase phase;

        public ActionBuilder(ActionType actionType) {
            this.actionType = actionType;
        }

        public ActionBuilder setInfluence(Integer influence) {
            this.influence = influence;
            return this;
        }

        public ActionBuilder setGold(Integer gold) {
            this.gold = gold;
            return this;
        }

        public ActionBuilder setCardNum(Integer cardNum) {
            this.cardNum = cardNum;
            return this;
        }

        public ActionBuilder setCardType(Class<? extends Card> cardType) {
            this.cardType = cardType;
            return this;
        }

        public ActionBuilder setPhase(Phase phase) {
            this.phase = phase;
            return this;
        }

        public Action createAction() {
            return new Action(actionType, influence, gold, cardNum, cardType, phase);
        }
    }
}
