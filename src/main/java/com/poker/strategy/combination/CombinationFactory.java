package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * Special factory for creating different types of card combination.
 *
 * @author Dmitry Shnurenko
 */
@Component
class CombinationFactory {

    /**
     * Creates card combination using set of cards from which combination is contained and combination type.
     *
     * @param cards           cards which combination has
     * @param combinationType combination type to define what card combination will be created
     * @return an instance of {@link CardCombination}
     */
    CardCombination createCombination(@Nonnull Set<Card> cards, @Nonnull CombinationType combinationType) {
        switch (combinationType) {
            case BEST_CARD:
                return new BestCard(cards);
            case PAIR:
                return new Pair(cards);
            case TWO_PAIRS:
                return new TwoPairs(cards);
            case TRIPLET:
                return new Triplet(cards);
            case STREET:
                return new Street(cards);
            case FLESH:
                return new Flesh(cards);
            case FULL_HOUSE:
                return new FullHouse(cards);
            case SQUARE:
                return new Square(cards);
            case STREET_FLESH:
                return new StreetFlesh(cards);
            case PORT_ROYAL:
                return new PortRoyal(cards);

            default:
                throw new IllegalArgumentException(getClass() + "The type of combination is incorrect...");
        }
    }
}
