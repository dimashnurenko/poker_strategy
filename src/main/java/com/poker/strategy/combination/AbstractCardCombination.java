package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * The common class for all card combinations which contains general business logic.
 *
 * @author Dmitry Shnurenko
 */
abstract class AbstractCardCombination implements CardCombination {

    protected Set<Card> cards;

    /**
     * Creates an instance of card combination using passed set of cards.
     *
     * @param cards cards which combination will contain
     */
    AbstractCardCombination(@Nonnull Set<Card> cards) {
        this.cards = cards;
    }

    /** {inheritDoc} */
    @Override
    public Set<Card> getCombinationCards() {
        return cards;
    }

    /** {inheritDoc} */
    @Override
    public Card getKicker() {
        return cards.stream().max((previous, next) -> previous.getRange().compareTo(next.getRange())).get();
    }
}
