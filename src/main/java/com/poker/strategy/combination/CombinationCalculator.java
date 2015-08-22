package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * The class contains business logic which allows define combination of cards using set of cards.
 *
 * @author Dmitry Shnurenko
 */
@Component
public class CombinationCalculator {

    private final CombinationFactory factory;

    @Autowired
    public CombinationCalculator(CombinationFactory factory) {
        this.factory = factory;
    }

    public CardCombination calculate(@Nonnull Set<Card> cards) {
        //TODO combination will contain seven cards from which we need define the most suitable combination
        return null;
    }
}