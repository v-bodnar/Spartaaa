package com.freetimers.spartacus.gamebox.action;

import com.freetimers.spartacus.gamebox.Card;
import com.freetimers.spartacus.gamebox.Phase;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Action {
    private final ActionType actionType;
    private final Integer influence;
    private final Integer gold;
    private final Integer cardNum;
//    private final Class<? extends Card> cardType;
    private final List<Phase> phases;

    public Action(ActionType actionType, Integer influence, Integer gold, Integer cardNum, List<Phase> phases) {
        this.actionType = Objects.requireNonNull(actionType);
        this.influence = influence;
        this.gold = gold;
        this.cardNum = cardNum;
//        this.cardType = cardType;
        this.phases = phases;
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

//    public Optional<Class<? extends Card>> getCardType() {
//        return Optional.ofNullable(cardType);
//    }

    public List<Phase> getPhases() {
        return phases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(influence, action.influence) &&
                Objects.equals(gold, action.gold) &&
                Objects.equals(cardNum, action.cardNum) &&
                Objects.equals(phases, action.phases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(influence, gold, cardNum, phases);
    }

    @Override
    public String toString() {
        return "Action{" +
                "influence=" + influence +
                ", gold=" + gold +
                ", cardNum=" + cardNum +
                ", phase=" + phases +
                '}';
    }

    public static class ActionBuilder {
        private final ActionType actionType;
        private Integer influence;
        private Integer gold;
        private Integer cardNum;
        private Class<? extends Card> cardType;
        private List<Phase> phases;

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

        public ActionBuilder setPhase(List<Phase> phases) {
            this.phases = phases;
            return this;
        }

        public ActionBuilder addPhase(Phase... phase){
            if (phases == null) {
                phases = List.of(phase);
            } else {
                phases.addAll(List.of(phase));
            }
            return this;
        }

        public Action createAction() {
            return new Action(actionType, influence, gold, cardNum, phases);
        }
    }
}
