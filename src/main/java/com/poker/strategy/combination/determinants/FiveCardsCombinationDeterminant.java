package com.poker.strategy.combination.determinants;

import com.poker.strategy.card.Card;
import com.poker.strategy.card.Range;

import javax.annotation.Nonnull;
import java.util.*;

import static com.poker.strategy.card.Range.TEN;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * The class contains business logic which allows define if combination is flesh,street or street-flesh.
 * For combination which has five cards.
 *
 * @author Dmitry Shnurenko
 */
public class FiveCardsCombinationDeterminant {

    private static final int STEP_TO_NEXT_RANGE = 1;

    private static final int FIVE_CARDS_COMBINATION = 5;

    private FiveCardsCombinationDeterminant() {
    }

    /**
     * Defines if cards combination is flesh or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is flesh, <code>false</code> combination is not flesh
     */
    public static boolean isFlesh(@Nonnull Set<Card> cards) {
        List<List<Card>> combinations = cards.stream()
                                             .collect(groupingBy(Card::getSuit))
                                             .values()
                                             .stream()
                                             .filter(list -> list.size() >= FIVE_CARDS_COMBINATION)
                                             .collect(toList());

        List<Card> currentCombination = combinations.isEmpty() ? Collections.emptyList() : combinations.get(0);

        return currentCombination.size() >= FIVE_CARDS_COMBINATION;
    }

    /**
     * Defines if cards combination is street or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is street, <code>false</code> combination is not street
     */
    public static boolean isStreet(@Nonnull Set<Card> cards) {
        //TODO need improve this method

        List<Integer> rangeOrder = cards.stream()
                                        .sorted(Card::compareTo)
                                        .map(Card::getRange)
                                        .map(Range::getIndex)
                                        .collect(toList());

        Iterator<Integer> orderIterator = rangeOrder.iterator();

        Set<Integer> combination = new HashSet<>();

        int currentIndex = orderIterator.next();

        while (orderIterator.hasNext()) {
            if (combination.size() == FIVE_CARDS_COMBINATION) {
                return true;
            }

            int nextIndex = orderIterator.next();

            if (nextIndex == currentIndex + STEP_TO_NEXT_RANGE) {
                combination.add(currentIndex);
                combination.add(nextIndex);

                currentIndex = nextIndex;

                continue;
            }

            currentIndex = nextIndex;

            combination.clear();
        }

        return combination.size() == FIVE_CARDS_COMBINATION;
    }

    /**
     * Defines if cards combination is street-flesh or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is street-flesh, <code>false</code> combination is not street-flesh
     */
    public static boolean isStreetFlesh(@Nonnull Set<Card> cards) {
        return isStreet(cards) && isFlesh(cards);
    }

    /**
     * Defines if cards combination is port-royal or not.
     *
     * @param cards combination of cards which will be checked
     * @return <code>true</code> combination is port-royal, <code>false</code> combination is not port-royal
     */
    public static boolean isPortRoyal(@Nonnull Set<Card> cards) {
        Range firstCardRange = cards.stream()
                                    .filter(card -> card.getRange().getIndex() >= 10)
                                    .sorted(Card::compareTo)
                                    .findFirst()
                                    .map(Card::getRange)
                                    .get();

        boolean streetStartsFromTen = TEN.equals(firstCardRange);

        return isStreetFlesh(cards) && streetStartsFromTen;
    }
}
