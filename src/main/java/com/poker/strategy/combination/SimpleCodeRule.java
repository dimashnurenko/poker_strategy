package com.poker.strategy.combination;

import com.poker.strategy.model.Range;
import com.poker.strategy.model.Suit;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.poker.strategy.model.Range.*;
import static com.poker.strategy.model.Suit.*;

/**
 * The class defines rules which determine simple string as a key to card range or suit. For example to get 'ACE' card
 * you need set key 'A'.
 *
 * @author Dmitry Shnurenko
 */
@Component(value = "simpleCodeRules")
final class SimpleCodeRule implements Rules {

    private final Map<String, Range> rangeRules;
    private final Map<String, Suit>  suitRules;

    SimpleCodeRule() {
        rangeRules = new HashMap<>();

        rangeRules.put("2", TWO);
        rangeRules.put("3", THREE);
        rangeRules.put("4", FOUR);
        rangeRules.put("5", FIVE);
        rangeRules.put("6", SIX);
        rangeRules.put("7", SEVEN);
        rangeRules.put("8", EIGHT);
        rangeRules.put("9", NINE);
        rangeRules.put("T", TEN);
        rangeRules.put("J", JACK);
        rangeRules.put("Q", QUEEN);
        rangeRules.put("K", KING);
        rangeRules.put("A", ACE);

        suitRules = new HashMap<>();

        suitRules.put("C", CROSS);
        suitRules.put("H", HEARTS);
        suitRules.put("P", PEAK);
        suitRules.put("D", DIAMONDS);
    }

    /**
     * Returns special rules for cards' ranges. There are map of ranges matches: key - CARD_RANGE{@link Range}
     * The returned map with rules is unmodifiable.
     * 2 - TWO
     * 3 - THREE
     * 4 - FOUR
     * 5 - FIVE
     * 6 - SIX
     * 7 - SEVEN
     * 8 - EIGHT
     * 9 - NINE
     * T - TEN
     * J - JACK
     * Q - QUEEN
     * K - KING
     * A - ACE
     */
    @Override
    @Nonnull
    public Map<String, Range> getRangeRules() {
        return Collections.unmodifiableMap(rangeRules);
    }

    /**
     * Returns special rules for cards' suits. There are map of suit matches: key - CARD_SUIT{@link Suit}
     * The returned map with rules is unmodifiable.
     * P - PEAK
     * C - CROSS
     * H - HEARTS
     * D - DIAMONDS
     */
    @Override
    @Nonnull
    public Map<String, Suit> getSuitRules() {
        return Collections.unmodifiableMap(suitRules);
    }
}
