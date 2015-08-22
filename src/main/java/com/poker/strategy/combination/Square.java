package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.SQUARE;

/**
 * The class represents cards combination which contains four cards with the same range. For example four ACEs.
 *
 * @author Dmitry Shnurenko
 */
class Square extends AbstractCardCombination {

    Square(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return SQUARE;
    }
}
