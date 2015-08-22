package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.STREET_FLESH;

/**
 * The class represents card combination which contains five cards in order with the same suit.
 * For example 2,3,4,5,6 all cards must be with the same range.
 *
 * @author Dmitry Shnurenko
 */
class StreetFlesh extends AbstractCardCombination {

    StreetFlesh(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return STREET_FLESH;
    }
}
