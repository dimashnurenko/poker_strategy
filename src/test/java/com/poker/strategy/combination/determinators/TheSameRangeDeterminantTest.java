package com.poker.strategy.combination.determinators;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.*;
import static com.poker.strategy.combination.determinators.TheSameRangeDeterminant.isTheSameRange;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class TheSameRangeDeterminantTest {

    @Test
    public void careShouldBeFounded() {
        Card card1 = new Card(KING, PEAK);
        Card card2 = new Card(KING, CROSS);
        Card card3 = new Card(KING, DIAMONDS);
        Card card4 = new Card(KING, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4));

        assertThat(isTheSameRange(cards), is(true));
    }

    @Test
    public void careShouldNotBeFounded() {
        Card card1 = new Card(KING, PEAK);
        Card card2 = new Card(KING, CROSS);
        Card card3 = new Card(QUEEN, DIAMONDS);
        Card card4 = new Card(KING, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4));

        assertThat(isTheSameRange(cards), is(false));
    }

    @Test
    public void tripletShouldBeFounded() {
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(JACK, CROSS);
        Card card3 = new Card(JACK, DIAMONDS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3));

        assertThat(isTheSameRange(cards), is(true));
    }

    @Test
    public void tripletShouldNotBeFounded() {
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(JACK, CROSS);
        Card card3 = new Card(NINE, DIAMONDS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3));

        assertThat(isTheSameRange(cards), is(false));
    }

    @Test
    public void pairShouldBeFounded() {
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(NINE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2));

        assertThat(isTheSameRange(cards), is(true));
    }

    @Test
    public void pairShouldNotBeFounded() {
        Card card1 = new Card(SIX, PEAK);
        Card card2 = new Card(NINE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2));

        assertThat(isTheSameRange(cards), is(false));
    }
}