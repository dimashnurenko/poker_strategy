package com.poker.strategy.card;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * The class represents all suits which deck of cards has. For each suit, special index is associated.
 *
 * @author Dmitry Shnurenko
 */
public enum Suit {

    PEAK(1), CROSS(2), HEARTS(3), DIAMONDS(4);

    private final int index;

    Suit(@Nonnegative int index) {
        this.index = index;
    }

    /** Returns special index associated with current instance of {@link Suit} */
    @Nonnegative
    public int getIndex() {
        return index;
    }

    /**
     * Defies {@link Suit} using special index, or can throw {@link IllegalArgumentException}
     * when index is incorrect.
     *
     * @param index index for which {@link Suit} will be defined
     * @return instance of {@link Suit}
     */
    @Nonnull
    public static Suit defineSuit(@Nonnegative int index) {
        for (Suit suit : values()) {
            if (index == suit.getIndex()) {
                return suit;
            }
        }

        throw new IllegalArgumentException("Suit is not defined for this index: " + index);
    }
}
