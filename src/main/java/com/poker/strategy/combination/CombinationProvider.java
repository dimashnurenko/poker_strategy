package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.poker.strategy.combination.CombinationName.*;

/**
 * The class contains business logic which allows define combination of cards using set of cards.
 *
 * @author Dmitry Shnurenko
 */
@Component
public class CombinationProvider {

    private final CombinationDeterminant determinant;

    @Autowired
    public CombinationProvider(CombinationDeterminant determinant) {
        this.determinant = determinant;
    }

    /**
     * Analyzes special set of cards and returns combination which matches to passed set of cards.
     *
     * @param cards set of cards which will be analyzed
     * @return an instance of {@link CardCombination}
     */
    @Nonnull
    public CardCombination getCombination(@Nonnull Set<Card> cards) {
        determinant.setCardCombination(cards);

        if (determinant.isPortRoyal()) {
            return CardCombination.of(cards, PORT_ROYAL);
        }

        if (determinant.isStreetFlesh()) {
            return CardCombination.of(cards, STREET_FLESH);
        }

        if (determinant.isSquare()) {
            return CardCombination.of(cards, SQUARE);
        }

        if (determinant.isFullHouse()) {
            return CardCombination.of(cards, FULL_HOUSE);
        }

        if (determinant.isFlesh()) {
            return CardCombination.of(cards, FLESH);
        }

        if (determinant.isStreet()) {
            return CardCombination.of(cards, STREET);
        }

        if (determinant.isTriplet()) {
            return CardCombination.of(cards, TRIPLET);
        }

        if (determinant.isTwoPairs()) {
            return CardCombination.of(cards, TWO_PAIRS);
        }

        if (determinant.isPair()) {
            return CardCombination.of(cards, PAIR);
        }

        return CardCombination.of(cards, BEST_CARD);
    }
}