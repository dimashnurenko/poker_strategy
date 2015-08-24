package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.*;
import static com.poker.strategy.combination.CombinationType.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CombinationProviderTest {

    private CombinationProvider provider;

    @Before
    public void setUp() {
        CombinationFactory factory = new CombinationFactory();

        provider = new CombinationProvider(factory);
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

        assertThat(combination.getCombinationType(), equalTo(BEST_CARD));
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

        assertThat(combination.getCombinationType(), equalTo(PAIR));
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

        assertThat(combination.getCombinationType(), equalTo(TWO_PAIRS));
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

        assertThat(combination.getCombinationType(), equalTo(TRIPLET));
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

        assertThat(combination.getCombinationType(), equalTo(STREET));
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

        assertThat(combination.getCombinationType(), equalTo(FLESH));
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

        assertThat(combination.getCombinationType(), equalTo(FULL_HOUSE));
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

        assertThat(combination.getCombinationType(), equalTo(SQUARE));
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

        assertThat(combination.getCombinationType(), equalTo(STREET_FLESH));
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

        assertThat(combination.getCombinationType(), equalTo(PORT_ROYAL));
    }
}