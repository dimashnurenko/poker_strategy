package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.PAIR;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class PairTest {

    @Test
    public void pairCombinationTypeShouldBeReturned() {
        Pair pair = new Pair(new HashSet<>());

        assertThat(pair.getCombinationType(), equalTo(PAIR));
    }
}