package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.STREET;

/**
 * The class contains information about street combination. And provides methods to get information
 * about combination.
 *
 * @author Dmitry Shnurenko
 */
class Street extends AbstractCardCombination {

    public Street(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return STREET;
    }
}
