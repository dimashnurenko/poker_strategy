package com.poker.strategy.combination;

import com.poker.strategy.card.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;

import static com.poker.strategy.card.Range.TWO;
import static com.poker.strategy.card.Suit.*;
import static com.poker.strategy.combination.CombinationType.SQUARE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class SquareTest {

    @Test
    public void fleshTypeShouldBeReturned() {
        Card card = new Card(TWO, PEAK);
        Card card1 = new Card(TWO, CROSS);
        Card card2 = new Card(TWO, HEARTS);
        Card card3 = new Card(TWO, DIAMONDS);

        Square square = new Square(new HashSet<>(Arrays.asList(card, card1, card2, card3)));

        assertThat(square.getCombinationType(), equalTo(SQUARE));
    }
}