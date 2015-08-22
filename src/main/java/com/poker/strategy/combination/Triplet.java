package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.TRIPLET;

/**
 * The class represents cards combination which contains three cards with the same range.For example three JACKs.
 *
 * @author Dmitry Shnurenko
 */
class Triplet extends AbstractCardCombination {

    Triplet(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return TRIPLET;
    }
}
