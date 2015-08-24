package com.poker.strategy.combination.determinants;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.*;
import static com.poker.strategy.combination.determinants.TheSameRangeDeterminant.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class TheSameRangeDeterminantTest {

    @Test
    public void pairShouldBeFound() {
        Card card3 = new Card(THREE, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(JACK, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isPair(cards), is(true));
    }

    @Test
    public void pairShouldNotBeDefined() {
        Card card3 = new Card(THREE, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(EIGHT, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(JACK, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isPair(cards), is(false));
    }

    @Test
    public void twoPairsShouldBeFound() {
        Card card3 = new Card(THREE, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(NINE, CROSS);
        Card card6 = new Card(THREE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isTwoPairs(cards), is(true));
    }

    @Test
    public void twoPairsShouldNotBeFound() {
        Card card3 = new Card(FOUR, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(NINE, CROSS);
        Card card6 = new Card(THREE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isTwoPairs(cards), is(false));
    }

    @Test
    public void tripletShouldBeFound() {
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isTriplet(cards), is(true));
    }

    @Test
    public void tripletShouldNotBeFound() {
        Card card1 = new Card(TEN, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isTriplet(cards), is(false));
    }

    @Test
    public void fullHouseShouldBeFound() {
        Card card2 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(FIVE, CROSS);
        Card card3 = new Card(NINE, HEARTS);
        Card card6 = new Card(JACK, HEARTS);
        Card card5 = new Card(FIVE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card1 = new Card(NINE, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isFullHouse(cards), is(true));
    }

    @Test
    public void fullHouseShouldNotBeFound() {
        Card card2 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(QUEEN, CROSS);
        Card card3 = new Card(NINE, HEARTS);
        Card card6 = new Card(JACK, HEARTS);
        Card card5 = new Card(FIVE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card1 = new Card(NINE, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isFullHouse(cards), is(false));
    }

    @Test
    public void squareShouldBeFound() {
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(NINE, DIAMONDS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isSquare(cards), is(true));
    }

    @Test
    public void squareShouldNotBeFound() {
        Card card1 = new Card(QUEEN, PEAK);
        Card card2 = new Card(NINE, DIAMONDS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isSquare(cards), is(false));
    }
}