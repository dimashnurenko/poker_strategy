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
import static com.poker.strategy.combination.determinants.FiveCardsCombinationDeterminant.*;
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
        Card card6 = new Card(TEN, HEARTS);
        Card card7 = new Card(JACK, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isStreet(cards), is(true));
    }

    @Test
    public void streetCombinationShouldBeFalse() {
        Card card2 = new Card(FIVE, CROSS);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, HEARTS);
        Card card6 = new Card(TEN, HEARTS);
        Card card7 = new Card(JACK, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isStreet(cards), is(false));
    }

    @Test
    public void fleshCombinationShouldBeTrue() {
        Card card2 = new Card(FIVE, PEAK);
        Card card7 = new Card(JACK, HEARTS);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);
        Card card1 = new Card(TWO, PEAK);
        Card card6 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isFlesh(cards), is(true));
    }

    @Test
    public void fleshCombinationShouldBeFalse() {
        Card card2 = new Card(FIVE, PEAK);
        Card card1 = new Card(TWO, DIAMONDS);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);
        Card card7 = new Card(TEN, DIAMONDS);
        Card card6 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isFlesh(cards), is(false));
    }

    @Test
    public void streetFleshCombinationShouldBeFounded() {
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);
        Card card3 = new Card(QUEEN, PEAK);
        Card card6 = new Card(THREE, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card7 = new Card(SIX, CROSS);
        Card card4 = new Card(KING, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isStreetFlesh(cards), is(true));
    }

    @Test
    public void streetFleshCombinationShouldNotBeFound() {
        Card card2 = new Card(TEN, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card3 = new Card(QUEEN, PEAK);
        Card card4 = new Card(KING, PEAK);
        Card card5 = new Card(TWO, PEAK);
        Card card6 = new Card(THREE, PEAK);
        Card card7 = new Card(SIX, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isStreetFlesh(cards), is(false));
    }

    @Test
    public void portRoyalCombinationShouldBeFound() {
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);
        Card card3 = new Card(QUEEN, PEAK);
        Card card6 = new Card(THREE, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card7 = new Card(SIX, CROSS);
        Card card4 = new Card(KING, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isPortRoyal(cards), is(true));
    }

    @Test
    public void portRoyalCombinationShouldNotBeFound() {
        Card card3 = new Card(QUEEN, PEAK);
        Card card4 = new Card(SIX, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);
        Card card6 = new Card(SEVEN, DIAMONDS);
        Card card7 = new Card(TWO, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        assertThat(isPortRoyal(cards), is(false));
    }
}