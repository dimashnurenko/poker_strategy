package com.poker.strategy.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.poker.strategy.model.Range.THREE;
import static com.poker.strategy.model.Range.TWO;
import static com.poker.strategy.model.Suit.PEAK;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CardTest {

    @Test
    public void rangeAndSuitShouldBeReturned() {
        Card card = new Card(TWO, PEAK);

        assertThat(card.getRange(), is(TWO));
        assertThat(card.getSuit(), is(PEAK));
    }

    @Test
    public void equalsShouldBeTested() {
        Card card1 = new Card(TWO, PEAK);
        Card card2 = new Card(TWO, PEAK);
        Card card3 = new Card(THREE, PEAK);

        assertThat(card1.equals(card2), is(true));
        assertThat(card1.equals(card3), is(false));

        card3 = card2;

        assertThat(card3.equals(card2), is(true));
    }

    @Test
    public void hashCodeShouldBeTested() {
        Card card1 = new Card(TWO, PEAK);
        Card card2 = new Card(TWO, PEAK);

        assertThat(card1.equals(card2), is(true));
        assertThat(card1.hashCode() == card2.hashCode(), is(true));
    }

    @Test
    public void cardsShouldBeComparedByRange() {
        Card first = new Card(TWO, PEAK);
        Card second = new Card(TWO, PEAK);
        Card third = new Card(THREE, PEAK);

        assertThat(first.compareTo(second), is(0));
        assertThat(first.compareTo(third), is(-1));
        assertThat(third.compareTo(first), is(1));
    }

}