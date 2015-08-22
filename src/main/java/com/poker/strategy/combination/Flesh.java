package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.FLESH;

/**
 * The class represents card combination which contains five cards with the same suit. For example A,3,4,5,6.
 *
 * @author Dmitry Shnurenko
 */
class Flesh extends AbstractCardCombination {

    Flesh(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return FLESH;
    }
}
