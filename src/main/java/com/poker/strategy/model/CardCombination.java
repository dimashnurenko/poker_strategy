package com.poker.strategy.model;

import com.poker.strategy.combination.CombinationName;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * The class contains information about card combination and provides business logic to get additional
 * information about combination.
 *
 * @author Dmitry Shnurenko
 */
public final class CardCombination {

    private final Set<Card>       cards;
    private final CombinationName combinationName;

    public static CardCombination of(@Nonnull Set<Card> cards, @Nonnull CombinationName combinationName) {
        return new CardCombination(cards, combinationName);
    }

    private CardCombination(@Nonnull Set<Card> cards, @Nonnull CombinationName combinationName) {
        this.cards = cards;
        this.combinationName = combinationName;
    }

    @Nonnull
    public Set<Card> getCombinationCards() {
        return cards;
    }

    @Nonnull
    public String getCombinationName() {
        return combinationName.toString();
    }

    /** Returns the senior card of combination */
    public Card getKicker() {
        return cards.stream().max(Card::compareTo).get();
    }
}