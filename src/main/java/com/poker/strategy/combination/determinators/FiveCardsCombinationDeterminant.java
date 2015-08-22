package com.poker.strategy.combination.determinators;

import com.poker.strategy.card.Card;
import com.poker.strategy.card.Range;
import com.poker.strategy.card.Suit;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static com.poker.strategy.card.Range.TEN;

/**
 * The class contains business logic which allows define if combination is flesh,street or street-flesh.
 * For combination which has five cards.
 *
 * @author Dmitry Shnurenko
 */
public interface FiveCardsCombinationDeterminant {

    final int STEP_TO_NEXT_RANGE = 1;

    /**
     * Defines if cards combination is flesh or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is flesh, <code>false</code> combination is not flesh
     */
    static boolean isFlesh(@Nonnull Set<Card> cards) {
        Card anyCard = cards.iterator().next();
        Suit combinationSuit = anyCard.getSuit();

        for (Card card : cards) {
            if (!combinationSuit.equals(card.getSuit())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Defines if cards combination is street or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is street, <code>false</code> combination is not street
     */
    static boolean isStreet(@Nonnull Set<Card> cards) {
        TreeSet<Card> sortedCardsByRange = new TreeSet<>(cards);

        Iterator<Card> cardIterator = sortedCardsByRange.iterator();

        int currentIndex = cardIterator.next().getRange().getIndex();

        while (cardIterator.hasNext()) {
            int nextIndex = cardIterator.next().getRange().getIndex();

            if (nextIndex == currentIndex + STEP_TO_NEXT_RANGE) {
                currentIndex = nextIndex;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Defines if cards combination is street-flesh or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is street-flesh, <code>false</code> combination is not street-flesh
     */
    static boolean isStreetFlesh(@Nonnull Set<Card> cards) {
        return isFlesh(cards) && isStreet(cards);
    }

    /**
     * Defines if cards combination is port-royal or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is port-royal, <code>false</code> combination is not port-royal
     */
    static boolean isPortRoyal(@Nonnull Set<Card> cards) {
        TreeSet<Card> sortedCardsByRange = new TreeSet<>(cards);

        Range firstCombinationCardRange = sortedCardsByRange.first().getRange();

        boolean streetStartsFromTen = TEN.equals(firstCombinationCardRange);

        return isStreetFlesh(cards) && streetStartsFromTen;
    }
}
