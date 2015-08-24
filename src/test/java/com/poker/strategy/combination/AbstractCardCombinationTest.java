package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.card.Range.*;
import static com.poker.strategy.card.Suit.*;
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

    @Test
    public void cardWithMaxRangeShouldBeReturned() {
        Card card1 = new Card(TWO, PEAK);
        Card card2 = new Card(ACE, CROSS);
        Card card3 = new Card(TEN, HEARTS);
        Card card4 = new Card(KING, DIAMONDS);
        Card card5 = new Card(JACK, HEARTS);

        Set<Card> cards = new HashSet<>(Arrays.asList(card1, card2, card3, card4, card5));

        DummyCombination combination = new DummyCombination(cards);

        Card result = combination.getKicker();

        assertThat(result.getRange(), equalTo(ACE));
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