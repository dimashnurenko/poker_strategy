package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import com.poker.strategy.card.Range;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.*;

import static com.poker.strategy.card.Range.TEN;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * The class contains business logic which allows determinate card combination.
 *
 * @author Dmitry Shnurenko
 */
@Component
public class CombinationDeterminant {

    private static final int STEP_TO_NEXT_RANGE = 1;

    private static final int ONE_CARD_COMBINATION    = 1;
    private static final int TWO_CARDS_COMBINATION   = 2;
    private static final int THREE_CARDS_COMBINATION = 3;
    private static final int FOUR_CARDS_COMBINATION  = 4;
    private static final int FIVE_CARDS_COMBINATION  = 5;

    private Set<Card> cards;

    public void setCardCombination(@Nonnull Set<Card> cards) {
        this.cards = cards;
    }

    /**
     * Defines if passed combination is pair or not.
     *
     * @return <code>true</code> if combination is Pair, <code>false</code> combination is not the Pair
     */
    public boolean isPair() {
        return defineSimpleCombination(cards, TWO_CARDS_COMBINATION);
    }

    private boolean defineSimpleCombination(@Nonnull Set<Card> cards, @Nonnegative int countCombinationCards) {
        List<List<Card>> combinations = getSameCardsCombinations(cards);

        if (combinations.isEmpty()) {
            return false;
        }

        int combinationSize = combinations.get(0).size();

        return isSimpleCombination(combinations) && combinationSize == countCombinationCards;
    }

    private List<List<Card>> getSameCardsCombinations(@Nonnull Set<Card> cards) {
        return cards.stream()
                    .collect(groupingBy(Card::getRange))
                    .values()
                    .stream()
                    .filter(list -> list.size() > ONE_CARD_COMBINATION)
                    .collect(toList());
    }

    private boolean isSimpleCombination(@Nonnull Collection<List<Card>> cards) {
        return cards.size() == ONE_CARD_COMBINATION;
    }

    /**
     * Defines if passed combination is two pairs or not.
     *
     * @return <code>true</code> if combination is two pairs, <code>false</code> combination is not the two pairs
     */
    public boolean isTwoPairs() {
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
     * @return <code>true</code> if combination is triplet, <code>false</code> combination is not the triplet
     */
    public boolean isTriplet() {
        return defineSimpleCombination(cards, THREE_CARDS_COMBINATION);
    }

    /**
     * Defines if passed combination is full house or not. This combination contains from two sub combinations
     * the first contains three cards and the second contains two cards.
     *
     * @return <code>true</code> if combination is full house, <code>false</code> combination is not the full house
     */
    public boolean isFullHouse() {
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
     * @return <code>true</code> if combination is square, <code>false</code> combination is not the square
     */
    public boolean isSquare() {
        return defineSimpleCombination(cards, FOUR_CARDS_COMBINATION);
    }


    /**
     * Defines if cards combination is flesh or not.
     *
     * @return <code>true</code> combination is flesh, <code>false</code> combination is not flesh
     */
    public boolean isFlesh() {
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
     * @return <code>true</code> combination is street, <code>false</code> combination is not street
     */
    public boolean isStreet() {
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
     * @return <code>true</code> combination is street-flesh, <code>false</code> combination is not street-flesh
     */
    public boolean isStreetFlesh() {
        return isStreet() && isFlesh();
    }

    /**
     * Defines if cards combination is port-royal or not.
     *
     * @return <code>true</code> combination is port-royal, <code>false</code> combination is not port-royal
     */
    public boolean isPortRoyal() {
        Range firstCardRange = cards.stream()
                                    .filter(card -> card.getRange().getIndex() >= TEN.getIndex())
                                    .sorted(Card::compareTo)
                                    .findFirst()
                                    .map(Card::getRange)
                                    .get();

        boolean streetStartsFromTen = TEN.equals(firstCardRange);

        return isStreetFlesh() && streetStartsFromTen;
    }
}
