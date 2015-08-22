package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.PORT_ROYAL;

/**
 * The class represents card combination which contains five cards with the same suit and starts from TEN.
 *
 * @author Dmitry Shnurenko
 */
class PortRoyal extends AbstractCardCombination {

    PortRoyal(@Nonnull Set<Card> cards) {
        super(cards);
    }

    /** {inheritDoc} */
    @Override
    public CombinationType getCombinationType() {
        return PORT_ROYAL;
    }
}
