package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.TEN;
import static com.poker.strategy.card.Suit.*;
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
        Triplet triplet = new Triplet(new HashSet<>(Arrays.asList(new Card(TEN, CROSS),
                                                                  new Card(TEN, HEARTS),
                                                                  new Card(TEN, PEAK))));

        assertThat(triplet.getCombinationType(), equalTo(TRIPLET));
    }
}