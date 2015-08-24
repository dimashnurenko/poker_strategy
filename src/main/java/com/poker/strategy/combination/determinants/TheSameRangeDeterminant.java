package com.poker.strategy.combination.determinants;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * The class contains business logic which allows define if combination contains cards whith the same range
 * or not. For combination which has four cards.
 *
 * @author Dmitry Shnurenko
 */
public class TheSameRangeDeterminant {

    private static final int TWO_CARDS_COMBINATION   = 2;
    private static final int THREE_CARDS_COMBINATION = 3;
    private static final int FOUR_CARDS_COMBINATION  = 4;

    private TheSameRangeDeterminant() {
    }

    /**
     * Defines if passed combination is pair or not.
     *
     * @param cards card combination which will be analyzed
     * @return <code>true</code> if combination is Pair, <code>false</code> combination is not the Pair
     */
    public static boolean isPair(@Nonnull Set<Card> cards) {
        return defineSimpleCombination(cards, TWO_CARDS_COMBINATION);
    }

    private static boolean defineSimpleCombination(@Nonnull Set<Card> cards, @Nonnegative int countCombinationCards) {
        Collection<List<Card>> combinations = getSameCardsCombinations(cards);

        if (combinations.isEmpty()) {
            return false;
        }

        int combinationSize = combinations.iterator().next().size();

        return isSimpleCombination(combinations) && combinationSize == countCombinationCards;
    }

    private static Collection<List<Card>> getSameCardsCombinations(@Nonnull Set<Card> cards) {
        final int oneCard = 1;

        return cards.stream()
                    .collect(groupingBy(Card::getRange))
                    .values()
                    .stream()
                    .filter(list -> list.size() > oneCard)
                    .collect(toList());
    }

    private static boolean isSimpleCombination(@Nonnull Collection<List<Card>> cards) {
        int countCombinations = cards.size();

        return countCombinations == 1;
    }

    /**
     * Defines if passed combination is two pairs or not.
     *
     * @param cards card combination which will be analyzed
     * @return <code>true</code> if combination is two pairs, <code>false</code> combination is not the two pairs
     */
    public static boolean isTwoPairs(@Nonnull Set<Card> cards) {
        Collection<List<Card>> combinations = getSameCardsCombinations(cards);

        boolean isTwoPairs = false;

        for (List<Card> list : combinations) {
            isTwoPairs = list.size() == TWO_CARDS_COMBINATION;
        }

        return !isSimpleCombination(combinations) && isTwoPairs;
    }

    /**
     * Defines if passed combination is triplet or not.
     *
     * @param cards card combination which will be analyzed
     * @return <code>true</code> if combination is triplet, <code>false</code> combination is not the triplet
     */
    public static boolean isTriplet(@Nonnull Set<Card> cards) {
        return defineSimpleCombination(cards, THREE_CARDS_COMBINATION);
    }

    /**
     * Defines if passed combination is full house or not. This combination contains from two sub combinations
     * the first contains three cards and the second contains two cards.
     *
     * @param cards card combination which will be analyzed
     * @return <code>true</code> if combination is full house, <code>false</code> combination is not the full house
     */
    public static boolean isFullHouse(@Nonnull Set<Card> cards) {
        final int fullHouseSizesCheckSum = 5;

        Collection<List<Card>> combinations = getSameCardsCombinations(cards);

        int checkSum = 0;

        for (List<Card> list : combinations) {
            checkSum += list.size();
        }

        return !isSimpleCombination(combinations) && checkSum == fullHouseSizesCheckSum;
    }

    /**
     * Defines if passed combination is square or not.
     *
     * @param cards card combination which will be analyzed
     * @return <code>true</code> if combination is square, <code>false</code> combination is not the square
     */
    public static boolean isSquare(@Nonnull Set<Card> cards) {
        return defineSimpleCombination(cards, FOUR_CARDS_COMBINATION);
    }
}
