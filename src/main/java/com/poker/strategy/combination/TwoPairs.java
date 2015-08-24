package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.TWO_PAIRS;

/**
 * The class represents card combination which contains two combinations with two cards with the same range.
 * For example two ACEs and two JACKs.
 *
 * @author Dmitry Shnurenko
 */
class TwoPairs extends AbstractCardCombination {

    TwoPairs(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return TWO_PAIRS;
    }
}
