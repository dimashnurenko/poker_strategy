package com.poker.strategy.combination.determinators;

import com.poker.strategy.card.Card;
import com.poker.strategy.card.Range;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * The class contains business logic which allows define if combination is care or not. For combination which
 * has four cards.
 *
 * @author Dmitry Shnurenko
 */
public interface TheSameRangeDeterminant {

    /**
     * Defines if cards combination is care or not. Via this method we can define combinations as pair, triple, square.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is care, <code>false</code> combination is not care
     */
    static boolean isTheSameRange(@Nonnull Set<Card> cards) {
        Card anyCard = cards.iterator().next();
        Range combinationRange = anyCard.getRange();

        for (Card card : cards) {
            if (!combinationRange.equals(card.getRange())) {
                return false;
            }
        }

        return true;
    }
}
