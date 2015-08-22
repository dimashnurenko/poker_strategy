package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.combination.CombinationType.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CombinationFactoryTest {

    private final Set<Card> cardSet = new HashSet<>();

    @Mock
    private Card card1;
    @Mock
    private Card card2;
    @Mock
    private Card card3;
    @Mock
    private Card card4;
    @Mock
    private Card card5;

    @InjectMocks
    private CombinationFactory factory;

    @Test
    public void bestCardCombinationShouldBeReturned() {
        cardSet.add(card1);

        CardCombination combination = factory.createCombination(cardSet, BEST_CARD);

        assertThat(combination.getCombinationType(), equalTo(BEST_CARD));
    }

    @Test
    public void pairCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);

        CardCombination combination = factory.createCombination(cardSet, PAIR);

        assertThat(combination.getCombinationType(), equalTo(PAIR));
    }

    @Test
    public void tripletCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);
        cardSet.add(card3);

        CardCombination combination = factory.createCombination(cardSet, TRIPLET);

        assertThat(combination.getCombinationType(), equalTo(TRIPLET));
    }

    @Test
    public void streetCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);
        cardSet.add(card3);
        cardSet.add(card4);
        cardSet.add(card5);

        CardCombination combination = factory.createCombination(cardSet, STREET);

        assertThat(combination.getCombinationType(), equalTo(STREET));
    }

    @Test
    public void fleshCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);
        cardSet.add(card3);
        cardSet.add(card4);
        cardSet.add(card5);

        CardCombination combination = factory.createCombination(cardSet, FLESH);

        assertThat(combination.getCombinationType(), equalTo(FLESH));
    }

    @Test
    public void squareCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);
        cardSet.add(card3);
        cardSet.add(card4);

        CardCombination combination = factory.createCombination(cardSet, SQUARE);

        assertThat(combination.getCombinationType(), equalTo(SQUARE));
    }

    @Test
    public void streetFleshCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);
        cardSet.add(card3);
        cardSet.add(card4);
        cardSet.add(card5);

        CardCombination combination = factory.createCombination(cardSet, STREET_FLESH);

        assertThat(combination.getCombinationType(), equalTo(STREET_FLESH));
    }

    @Test
    public void portRoyalCombinationShouldBeReturned() {
        cardSet.add(card1);
        cardSet.add(card2);
        cardSet.add(card3);
        cardSet.add(card4);
        cardSet.add(card5);

        CardCombination combination = factory.createCombination(cardSet, PORT_ROYAL);

        assertThat(combination.getCombinationType(), equalTo(PORT_ROYAL));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrownWhenWrongCombinationTypeShouldBePassed() {
        cardSet.add(card1);
        cardSet.add(card2);

        factory.createCombination(cardSet, UNKNOWN);
    }
}