package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.FULL_HOUSE;

/**
 * The class represents card combination which contains two combinations.One combination contains three cards
 * with the same range and other combination contains two cards with the same range. For example
 * two ACEs and three JACKs.
 *
 * @author Dmitry Shnurenko
 */
class FullHouse extends AbstractCardCombination {

    FullHouse(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return FULL_HOUSE;
    }
}
