package com.poker.strategy.combination;

import com.poker.strategy.model.Card;
import com.poker.strategy.model.CardCombination;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.model.Range.*;
import static com.poker.strategy.model.Suit.*;
import static com.poker.strategy.combination.CombinationName.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CombinationProviderTest {

    private CombinationProvider provider;

    @Before
    public void setUp() {
        CombinationDeterminant determinant = new CombinationDeterminant();

        provider = new CombinationProvider(determinant);
    }

    @Test
    public void bestCardCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(FIVE, DIAMONDS);
        Card card4 = new Card(EIGHT, PEAK);
        Card card5 = new Card(TEN, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(BEST_CARD.name())));
    }

    @Test
    public void pairCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(TWO, DIAMONDS);
        Card card4 = new Card(EIGHT, PEAK);
        Card card5 = new Card(TEN, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(PAIR.name())));
    }

    @Test
    public void twoPairsCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(TWO, DIAMONDS);
        Card card4 = new Card(EIGHT, PEAK);
        Card card5 = new Card(FOUR, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(TWO_PAIRS.name())));
    }

    @Test
    public void tripletCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(TWO, DIAMONDS);
        Card card4 = new Card(EIGHT, PEAK);
        Card card5 = new Card(TEN, CROSS);
        Card card6 = new Card(TWO, HEARTS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(TRIPLET.name())));
    }

    @Test
    public void streetCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(THREE, DIAMONDS);
        Card card4 = new Card(EIGHT, PEAK);
        Card card5 = new Card(SIX, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(FIVE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(STREET.name())));
    }

    @Test
    public void fleshCombinationShouldBeReturned() {
        Card card1 = new Card(NINE, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(TWO, CROSS);
        Card card4 = new Card(EIGHT, CROSS);
        Card card5 = new Card(TEN, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(ACE, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(FLESH.name())));
    }

    @Test
    public void fullHouseCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(TEN, HEARTS);
        Card card3 = new Card(TWO, DIAMONDS);
        Card card4 = new Card(EIGHT, PEAK);
        Card card5 = new Card(TEN, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(TEN, PEAK);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(FULL_HOUSE.name())));
    }

    @Test
    public void squareCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(FOUR, HEARTS);
        Card card3 = new Card(TWO, DIAMONDS);
        Card card4 = new Card(TWO, PEAK);
        Card card5 = new Card(TEN, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card7 = new Card(TWO, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(SQUARE.name())));
    }

    @Test
    public void streetFleshCombinationShouldBeReturned() {
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(THREE, CROSS);
        Card card6 = new Card(QUEEN, DIAMONDS);
        Card card3 = new Card(FOUR, CROSS);
        Card card4 = new Card(FIVE, CROSS);
        Card card7 = new Card(ACE, CROSS);
        Card card5 = new Card(SIX, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(STREET_FLESH.name())));
    }

    @Test
    public void portRoyalFleshCombinationShouldBeReturned() {
        Card card1 = new Card(TEN, CROSS);
        Card card4 = new Card(FIVE, DIAMONDS);
        Card card5 = new Card(SIX, PEAK);
        Card card2 = new Card(JACK, CROSS);
        Card card3 = new Card(KING, CROSS);
        Card card7 = new Card(ACE, CROSS);
        Card card6 = new Card(QUEEN, CROSS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));

        CardCombination combination = provider.getCombination(cards);

        assertThat(combination.getCombinationName(), is(equalTo(PORT_ROYAL.name())));
    }
}