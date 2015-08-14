package com.poker.strategy.card;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.poker.strategy.card.Range.TWO;
import static com.poker.strategy.card.Range.defineRange;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class RangeTest {

    @Test
    public void indexShouldBeReturned() {
        assertThat(TWO.getIndex(), is(2));
    }

    @Test
    public void rangeShouldBeDefined() {
        assertThat(Range.defineRange(2), is(TWO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrown() {
        defineRange(25);
    }
}