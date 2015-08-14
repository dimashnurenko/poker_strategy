package com.poker.strategy.card;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static com.poker.strategy.card.Range.TWO;
import static com.poker.strategy.card.Suit.PEAK;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class DeckTest {

    @InjectMocks
    private Deck deck;

    @Test
    public void cardSizeShouldBeEqual52() {
        assertThat(deck.getCardsCount(), is(52));
    }

    @Test
    public void deckShouldContainAllCards() {
        for (Range range : Range.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(range, suit);

                assertThat(deck.containCard(card), is(true));
            }
        }
    }

    @Test
    public void cardShouldBeGotFromDeck() {
        Card testCard = new Card(TWO, PEAK);

        deck.getCard(testCard);

        assertThat(deck.containCard(testCard), is(false));
    }
}