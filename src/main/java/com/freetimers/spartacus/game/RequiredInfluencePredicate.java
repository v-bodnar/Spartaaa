package com.freetimers.spartacus.game;

import java.util.function.Predicate;

public class RequiredInfluencePredicate implements Predicate<Intrigue> {
    @Override
    public boolean test(Intrigue intrigue) {
        final int sourceDominusInfluence = intrigue.getSourceDominus().getInfluence();
        final int supportDominusInfluence = intrigue.getSupportDominus().getInfluence();
        final int requiredInfluence = intrigue.getIntrigueCard().getRequiredInfluence();

        switch (intrigue.getIntrigueCard().getRequiredInfluenceCondition()) {
            case LESS_THEN:
                return (sourceDominusInfluence + supportDominusInfluence) < requiredInfluence;
            case MORE_THEN:
                return (sourceDominusInfluence + supportDominusInfluence) > requiredInfluence;
            case MORE_OR_EQUAL:
                return (sourceDominusInfluence + supportDominusInfluence) >= requiredInfluence;
            default:
                throw new IllegalStateException("Unexpected value: " + intrigue.getIntrigueCard().getRequiredInfluenceCondition());
        }

    }
}
