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
import static com.poker.strategy.combination.determinators.FiveCardsCombinationDeterminant.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class FiveCardsCombinationTypeDeterminantTest {

    @Test
    public void streetCombinationShouldBeTrue() {
        Card card2 = new Card(FIVE, CROSS);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(FOUR, DIAMONDS);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isStreet(cards), is(true));
    }

    @Test
    public void streetCombinationShouldBeFalse() {
        Card card2 = new Card(FIVE, CROSS);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isStreet(cards), is(false));
    }

    @Test
    public void fleshCombinationShouldBeTrue() {
        Card card2 = new Card(FIVE, PEAK);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isFlesh(cards), is(true));
    }

    @Test
    public void fleshCombinationShouldBeFalse() {
        Card card2 = new Card(FIVE, PEAK);
        Card card1 = new Card(TWO, DIAMONDS);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isFlesh(cards), is(false));
    }

    @Test
    public void streetFleshCombinationShouldBeFounded() {
        Card card2 = new Card(FIVE, PEAK);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isStreetFlesh(cards), is(true));
    }

    @Test
    public void streetFleshCombinationShouldNotBeFounded() {
        Card card2 = new Card(FIVE, PEAK);
        Card card1 = new Card(SIX, PEAK);
        Card card3 = new Card(FOUR, DIAMONDS);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isStreetFlesh(cards), is(false));
    }

    @Test
    public void portRoyalCombinationShouldBeFounded() {
        Card card3 = new Card(QUEEN, PEAK);
        Card card4 = new Card(KING, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isPortRoyal(cards), is(true));
    }

    @Test
    public void portRoyalCombinationShouldNotBeFounded() {
        Card card3 = new Card(QUEEN, PEAK);
        Card card4 = new Card(SIX, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        assertThat(isPortRoyal(cards), is(false));
    }
}