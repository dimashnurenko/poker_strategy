package com.poker.strategy.combination;

import com.poker.strategy.model.Card;
import com.poker.strategy.model.Range;
import com.poker.strategy.model.Suit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The class contains business logic which allows resolve card combination using special code and rules.
 *
 * @author Dmitry Shnurenko
 */
@Component
public class CombinationResolver {

    private static final int COMBINATION_SYMBOLS_COUNT = 2;

    private final Rules simpleCodeRules;

    @Autowired
    public CombinationResolver(Rules simpleCodeRules) {
        this.simpleCodeRules = simpleCodeRules;
    }

    /**
     * The method determines card combination using special code. The combination code contains of seven cards.
     * For example following code 2C 3P JP QD AC KP QC is 2_CROSS 3_PEAK JACK_PEAK QUEEN_DIAMONDS ACE_CROSS KING_PEAK
     * QUEEN_CROSS combination.
     *
     * @param code code which will be converted to card combination
     * @return set of cards
     */
    public Set<Card> resolve(@Nonnull String code) {
        Set<Card> cards = new HashSet<>();

        String[] cardsCodes = code.split(" ");

        Map<String, Range> rangeRules = simpleCodeRules.getRangeRules();
        Map<String, Suit> suitRules = simpleCodeRules.getSuitRules();

        for (String cardCode : cardsCodes) {
            String[] combinationSymbols = cardCode.split("");

            if (combinationSymbols.length != COMBINATION_SYMBOLS_COUNT) {
                throw new IllegalArgumentException("Combination code must contain only two symbols. The one is " +
                                                           "combination Range, the next one is combination Suit");
            }

            String rangeCode = combinationSymbols[0];
            String suitCode = combinationSymbols[1];

            Range range = rangeRules.get(rangeCode);
            Suit suit = suitRules.get(suitCode);

            if (range == null) {
                throw new IllegalArgumentException("Combination not resolved. the range rule " +
                                                           "don't exist for this code " + rangeCode);
            }

            if (suit == null) {
                throw new IllegalArgumentException("Combination not resolved. the suit rule " +
                                                           "don't exist for this code " + rangeCode);
            }

            cards.add(new Card(range, suit));
        }

        return cards;
    }
}
