package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CombinationDeterminantTest {

    @InjectMocks
    private CombinationDeterminant determinant;

    @Test
    public void pairCombinationShouldBeDefined() {
        Card card3 = new Card(THREE, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(JACK, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isPair(), is(equalTo(true)));
    }

    @Test
    public void pairCombinationShouldNotBeDefined() {
        Card card3 = new Card(THREE, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(EIGHT, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(JACK, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isPair(), is(equalTo(false)));
    }

    @Test
    public void twoPairsCombinationShouldBeDefined() {
        Card card3 = new Card(THREE, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(NINE, CROSS);
        Card card6 = new Card(THREE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isTwoPairs(), is(equalTo(true)));
    }

    @Test
    public void twoPairsCombinationShouldNotBeDefined() {
        Card card3 = new Card(FOUR, HEARTS);
        Card card1 = new Card(NINE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card4 = new Card(NINE, CROSS);
        Card card6 = new Card(THREE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isTwoPairs(), is(equalTo(false)));
    }

    @Test
    public void tripletCombinationShouldBeDefined() {
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isTriplet(), is(equalTo(true)));
    }

    @Test
    public void tripletCombinationShouldNotBeDefined() {
        Card card1 = new Card(TEN, PEAK);
        Card card2 = new Card(TWO, CROSS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isTriplet(), is(equalTo(false)));
    }

    @Test
    public void fullHouseCombinationShouldBeDefined() {
        Card card2 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(FIVE, CROSS);
        Card card3 = new Card(NINE, HEARTS);
        Card card6 = new Card(JACK, HEARTS);
        Card card5 = new Card(FIVE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card1 = new Card(NINE, PEAK);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isFullHouse(), is(equalTo(true)));
    }

    @Test
    public void fullHouseCombinationShouldNotBeDefined() {
        Card card2 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(QUEEN, CROSS);
        Card card3 = new Card(NINE, HEARTS);
        Card card6 = new Card(JACK, HEARTS);
        Card card5 = new Card(FIVE, PEAK);
        Card card7 = new Card(ACE, CROSS);
        Card card1 = new Card(NINE, PEAK);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isFullHouse(), is(equalTo(false)));
    }

    @Test
    public void squareCombinationShouldBeDefined() {
        Card card1 = new Card(NINE, PEAK);
        Card card2 = new Card(NINE, DIAMONDS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isSquare(), is(equalTo(true)));
    }

    @Test
    public void squareCombinationShouldNotBeDefined() {
        Card card1 = new Card(QUEEN, PEAK);
        Card card2 = new Card(NINE, DIAMONDS);
        Card card3 = new Card(THREE, HEARTS);
        Card card4 = new Card(NINE, CROSS);
        Card card5 = new Card(FIVE, PEAK);
        Card card6 = new Card(NINE, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isSquare(), is(equalTo(false)));
    }

    @Test
    public void streetCombinationShouldBeDefined() {
        Card card2 = new Card(FIVE, CROSS);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(FOUR, DIAMONDS);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, HEARTS);
        Card card6 = new Card(TEN, HEARTS);
        Card card7 = new Card(JACK, HEARTS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isStreet(), is(equalTo(true)));
    }

    @Test
    public void streetCombinationShouldNotBeDefined() {
        Card card2 = new Card(FIVE, CROSS);
        Card card1 = new Card(TWO, PEAK);
        Card card3 = new Card(NINE, DIAMONDS);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, HEARTS);
        Card card6 = new Card(TEN, HEARTS);
        Card card7 = new Card(JACK, HEARTS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isStreet(), is(equalTo(false)));
    }

    @Test
    public void fleshCombinationShouldBeDefined() {
        Card card2 = new Card(FIVE, PEAK);
        Card card7 = new Card(JACK, HEARTS);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);
        Card card1 = new Card(TWO, PEAK);
        Card card6 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isFlesh(), is(equalTo(true)));
    }

    @Test
    public void fleshCombinationShouldNotBeDefined() {
        Card card2 = new Card(FIVE, PEAK);
        Card card1 = new Card(TWO, DIAMONDS);
        Card card3 = new Card(FOUR, PEAK);
        Card card4 = new Card(THREE, PEAK);
        Card card5 = new Card(SIX, PEAK);
        Card card7 = new Card(TEN, DIAMONDS);
        Card card6 = new Card(ACE, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isFlesh(), is(equalTo(false)));
    }

    @Test
    public void streetFleshCombinationShouldBeDefined() {
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);
        Card card3 = new Card(QUEEN, PEAK);
        Card card6 = new Card(THREE, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card7 = new Card(SIX, CROSS);
        Card card4 = new Card(KING, PEAK);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isStreetFlesh(), is(equalTo(true)));
    }

    @Test
    public void streetFleshCombinationShouldNotBeDefined() {
        Card card2 = new Card(TEN, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card3 = new Card(QUEEN, PEAK);
        Card card4 = new Card(KING, PEAK);
        Card card5 = new Card(TWO, PEAK);
        Card card6 = new Card(THREE, PEAK);
        Card card7 = new Card(SIX, CROSS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isStreetFlesh(), is(equalTo(false)));
    }

    @Test
    public void portRoyalCombinationShouldBeDefined() {
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);
        Card card3 = new Card(QUEEN, PEAK);
        Card card6 = new Card(THREE, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card7 = new Card(SIX, CROSS);
        Card card4 = new Card(KING, PEAK);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isPortRoyal(), is(equalTo(true)));
    }

    @Test
    public void portRoyalCombinationShouldNotBeDefined() {
        Card card3 = new Card(QUEEN, PEAK);
        Card card4 = new Card(SIX, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(TEN, PEAK);
        Card card5 = new Card(ACE, PEAK);
        Card card6 = new Card(SEVEN, DIAMONDS);
        Card card7 = new Card(TWO, HEARTS);

        determinant.setCardCombination(new HashSet<>(asList(card1, card2, card3, card4, card5, card6, card7)));

        assertThat(determinant.isPortRoyal(), is(equalTo(false)));
    }
}