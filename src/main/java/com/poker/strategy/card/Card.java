package com.poker.strategy.card;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * The class define one special card in deck of cards. Contains methods which allow get information
 * about range or suit of card.
 *
 * @author Dmitry Shnurenko
 */
public class Card {

    private final Range range;
    private final Suit  suit;

    Card(@Nonnull Range range, @Nonnull Suit suit) {
        this.range = range;
        this.suit = suit;
    }

    @Nonnull
    public Range getRange() {
        return range;
    }

    @Nonnull
    public Suit getSuit() {
        return suit;
    }

    /** {inheritDoc} */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }

        Card card = (Card) other;

        return range == card.range && suit == card.suit;

    }

    /** {inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(range, suit);
    }
}
