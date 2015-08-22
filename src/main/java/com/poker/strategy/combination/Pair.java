package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.PAIR;

/**
 * The class represents card combination which contains two cards with the same range. For example two ACEs.
 *
 * @author Dmitry Shnurenko
 */
class Pair extends AbstractCardCombination {

    Pair(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return PAIR;
    }
}
