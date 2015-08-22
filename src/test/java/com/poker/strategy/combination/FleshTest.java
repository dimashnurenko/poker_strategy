package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.PEAK;
import static com.poker.strategy.combination.CombinationType.FLESH;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class FleshTest {

    @Test
    public void fleshTypeShouldBeReturned() {
        Card card = new Card(TWO, PEAK);
        Card card1 = new Card(THREE, PEAK);
        Card card2 = new Card(FOUR, PEAK);
        Card card3 = new Card(NINE, PEAK);
        Card card4 = new Card(SIX, PEAK);

        Flesh flesh = new Flesh(new HashSet<>(Arrays.asList(card, card1, card2, card3, card4)));

        assertThat(flesh.getCombinationType(), equalTo(FLESH));
    }
}