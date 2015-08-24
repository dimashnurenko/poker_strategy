package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.*;
import static com.poker.strategy.combination.determinants.FiveCardsCombinationDeterminant.*;
import static com.poker.strategy.combination.determinants.TheSameRangeDeterminant.*;

/**
 * The class contains business logic which allows define combination of cards using set of cards.
 *
 * @author Dmitry Shnurenko
 */
@Component
public class CombinationProvider {

    private final CombinationFactory factory;

    @Autowired
    public CombinationProvider(CombinationFactory factory) {
        this.factory = factory;
    }

    /**
     * Analyzes special set of cards and returns combination which matches to current set of cards.
     *
     * @param cards set of cards which will be analyzed
     * @return an instance of {@link CardCombination}
     */
    public CardCombination getCombination(@Nonnull Set<Card> cards) {
        if (isPortRoyal(cards)) {
            return factory.createCombination(cards, PORT_ROYAL);
        }

        if (isStreetFlesh(cards)) {
            return factory.createCombination(cards, STREET_FLESH);
        }

        if (isSquare(cards)) {
            return factory.createCombination(cards, SQUARE);
        }

        if (isFullHouse(cards)) {
            return factory.createCombination(cards, FULL_HOUSE);
        }

        if (isFlesh(cards)) {
            return factory.createCombination(cards, FLESH);
        }

        if (isStreet(cards)) {
            return factory.createCombination(cards, STREET);
        }

        if (isTriplet(cards)) {
            return factory.createCombination(cards, TRIPLET);
        }

        if (isTwoPairs(cards)) {
            return factory.createCombination(cards, TWO_PAIRS);
        }

        if (isPair(cards)) {
            return factory.createCombination(cards, PAIR);
        }

        return factory.createCombination(cards, BEST_CARD);
    }
}