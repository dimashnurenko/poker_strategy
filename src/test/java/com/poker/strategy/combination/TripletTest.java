package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.TRIPLET;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class TripletTest {

    @Test
    public void combinationTypeShouldBeReturned() {
        Triplet triplet = new Triplet(new HashSet<>());

        assertThat(triplet.getCombinationType(), equalTo(TRIPLET));
    }
}