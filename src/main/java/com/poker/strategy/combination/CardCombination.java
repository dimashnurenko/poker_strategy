package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import java.util.Set;

/**
 * The main abstraction of card combination. Provides methods which allows define combination and cards which
 * it contains.
 *
 * @author Dmitry Shnurenko
 */
public interface CardCombination {

    /** Returns set of cards which combination contains. */
    Set<Card> getCombinationCards();

    /** Returns type of card combination. For example {@link com.poker.strategy.combination.Pair} */
    CombinationType getCombinationType();

    /** Returns the senior card of combination. */
    Card getKicker();

}
