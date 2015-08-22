package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.PEAK;
import static com.poker.strategy.combination.CombinationType.PORT_ROYAL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class PortRoyalTest {

    @Test
    public void portRoyalTypeShouldBeReturned() {
        Card card = new Card(TEN, PEAK);
        Card card1 = new Card(JACK, PEAK);
        Card card2 = new Card(QUEEN, PEAK);
        Card card3 = new Card(KING, PEAK);
        Card card4 = new Card(ACE, PEAK);

        PortRoyal portRoyal = new PortRoyal(new HashSet<>(Arrays.asList(card, card1, card2, card3, card4)));

        assertThat(portRoyal.getCombinationType(), equalTo(PORT_ROYAL));
    }
}