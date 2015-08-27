package com.poker.strategy.combination;

import com.poker.strategy.card.Card;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * The class contains information about card combination and provides business logic to get additional
 * information about combination. The combination contains seven cards.
 *
 * @author Dmitry Shnurenko
 */
public class CardCombination {

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
    public CombinationName getCombinationName() {
        return combinationName;
    }

    /** Returns the senior card of combination */
    public Card getKicker() {
        return cards.stream().max(Card::compareTo).get();
    }
}