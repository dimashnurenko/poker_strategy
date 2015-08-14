package com.poker.strategy.card;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.poker.strategy.card.Suit.PEAK;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class SuitTest {

    @Test
    public void indexShouldBeReturned() {
        assertThat(PEAK.getIndex(), is(1));
    }

    @Test
    public void rangeShouldBeDefined() {
        assertThat(Suit.defineSuit(1), is(PEAK));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrown() {
        Suit.defineSuit(5);
    }
}