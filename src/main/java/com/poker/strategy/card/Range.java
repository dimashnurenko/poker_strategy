package com.poker.strategy.card;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * The class represents all ranges which deck of cards has. For each range, special index is associated. The value
 * of index depends on value of range. The bigger range, the bigger index.
 *
 * @author Dmitry Shnurenko
 */
public enum Range {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private final int index;

    Range(@Nonnegative int index) {
        this.index = index;
    }

    /** Returns special index associated with current instance of {@link Range} */
    @Nonnegative
    public int getIndex() {
        return index;
    }

    /**
     * Defies {@link Range} using special index, or can throw {@link IllegalArgumentException}
     * when index is incorrect.
     *
     * @param index index for which {@link Range} will be defined
     * @return instance of {@link Range}
     */
    @Nonnull
    public static Range defineRange(@Nonnegative int index) {
        for (Range range : values()) {
            if (index == range.getIndex()) {
                return range;
            }
        }

        throw new IllegalArgumentException("Range is not defined for this index: " + index);
    }
}
