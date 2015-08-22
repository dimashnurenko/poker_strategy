package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.card.Range.TWO;
import static com.poker.strategy.card.Suit.PEAK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractCardCombinationTest {

    @Test
    public void cardsSetShouldBeReturned() {
        Card card = new Card(TWO, PEAK);
        DummyCombination combination = new DummyCombination(new HashSet<>(Arrays.asList(card)));

        Set<Card> cards = combination.getCombinationCards();

        assertThat(cards.size(), equalTo(1));
        assertThat(cards.iterator().next(), equalTo(card));
    }

    private class DummyCombination extends AbstractCardCombination {

        DummyCombination(@Nonnull Set<Card> cards) {
            super(cards);
        }

        @Override
        public CombinationType getCombinationType() {
            throw new UnsupportedOperationException("Method is not supported in this mode...");
        }
    }

}