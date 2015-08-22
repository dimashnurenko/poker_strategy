package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.BEST_CARD;

/**
 * The class represents combination which contains only one card. For example it can be NINE of CROSS
 * or any other card.
 *
 * @author Dmitry Shnurenko
 */
class BestCard extends AbstractCardCombination {

    BestCard(@Nonnull Set<Card> bestCardSet) {
        super(bestCardSet);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return BEST_CARD;
    }
}
