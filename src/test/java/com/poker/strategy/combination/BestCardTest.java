package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.ACE;
import static com.poker.strategy.card.Suit.HEARTS;
import static com.poker.strategy.combination.CombinationType.BEST_CARD;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class BestCardTest {

    @Test
    public void typeShouldBeReturned() {
        Card card = new Card(ACE, HEARTS);

        BestCard bestCard = new BestCard(new HashSet<>(Arrays.asList(card)));

        assertThat(bestCard.getCombinationType(), equalTo(BEST_CARD));
    }
}