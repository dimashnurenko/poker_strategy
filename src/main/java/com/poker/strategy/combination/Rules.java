package com.poker.strategy.combination;

import com.poker.strategy.model.Range;
import com.poker.strategy.model.Suit;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * The interface which defines special rules for resolving combination. For example rules can define that string
 * 'A' is an ace in the deck of cards. The rules match some card range or suit to special symbol (number, character,
 * string, etc).
 *
 * @author Dmitry Shnurenko
 */
interface Rules {

    /** Returns map which contains mapping some string to range of a card. */
    @Nonnull Map<String, Range> getRangeRules();

    /** Returns map which contains mapping some string to suit of a card. */
    @Nonnull Map<String, Suit> getSuitRules();
}
