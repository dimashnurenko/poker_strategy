package com.poker.strategy.card;

import org.springframework.stereotype.Component;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

/**
 * The class contains business logic which allows control deck of cards and do some actions with deck.
 *
 * @author Dmitry Shnurenko
 */
@Component
public class Deck {

    private final Set<Card> cards;

    public Deck() {
        this.cards = new HashSet<>();

        for (Range range : Range.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(range, suit));
            }
        }
    }

    /**
     * Removes current card from deck.
     *
     * @param card card which will be removed
     */
    public void getCard(@Nonnull Card card) {
        cards.remove(card);
    }

    /** Returns count of cards in deck. */
    @Nonnegative
    public int getCardsCount() {
        return cards.size();
    }

    /**
     * Returns flag if deck has current card or not.
     *
     * @param card card which will be checked
     * @return <code>true</code> card is in deck, <code>false</code> card is absent in deck
     */
    public boolean containCard(@Nonnull Card card) {
        return cards.contains(card);
    }

}
