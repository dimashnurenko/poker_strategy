package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.PEAK;
import static com.poker.strategy.combination.CombinationType.STREET_FLESH;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class StreetFleshTest {

    @Test
    public void streetFleshTypeShouldBeReturned() {
        Card card = new Card(TWO, PEAK);
        Card card1 = new Card(THREE, PEAK);
        Card card2 = new Card(FOUR, PEAK);
        Card card3 = new Card(FIVE, PEAK);
        Card card4 = new Card(SIX, PEAK);

        StreetFlesh streetFlesh = new StreetFlesh(new HashSet<>(Arrays.asList(card, card1, card2, card3, card4)));

        assertThat(streetFlesh.getCombinationType(), equalTo(STREET_FLESH));
    }

}