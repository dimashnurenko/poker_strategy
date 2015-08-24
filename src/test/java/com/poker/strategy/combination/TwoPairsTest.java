package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.TWO_PAIRS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class TwoPairsTest {

    @Test
    public void twoPairsCombinationShouldBeReturned() {
        TwoPairs twoPairs = new TwoPairs(new HashSet<>());

        assertThat(twoPairs.getCombinationType(), equalTo(TWO_PAIRS));
    }
}