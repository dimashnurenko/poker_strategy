package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.TEN;
import static com.poker.strategy.card.Suit.CROSS;
import static com.poker.strategy.card.Suit.HEARTS;
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
        Pair pair = new Pair(new HashSet<>(Arrays.asList(new Card(TEN, CROSS),
                                                         new Card(TEN, HEARTS))));

        assertThat(pair.getCombinationType(), equalTo(PAIR));
    }
}