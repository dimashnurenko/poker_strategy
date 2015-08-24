package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

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
        Flesh flesh = new Flesh(new HashSet<>());

        assertThat(flesh.getCombinationType(), equalTo(FLESH));
    }
}