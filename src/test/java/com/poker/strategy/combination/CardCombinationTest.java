package com.poker.strategy.combination;

import com.poker.strategy.model.Card;
import com.poker.strategy.model.CardCombination;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static com.poker.strategy.model.Range.TEN;
import static com.poker.strategy.model.Range.TWO;
import static com.poker.strategy.model.Suit.HEARTS;
import static com.poker.strategy.model.Suit.PEAK;
import static com.poker.strategy.combination.CombinationName.BEST_CARD;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CardCombinationTest {

    private Card card1 = new Card(TWO, PEAK);
    private Card card2 = new Card(TEN, HEARTS);

    private CardCombination cardCombination;

    @Before
    public void setUp() {
        cardCombination = CardCombination.of(new HashSet<>(asList(card1, card2)), BEST_CARD);
    }

    @Test
    public void shouldReturnCardSetFromCombination() {
        Set<Card> cards = cardCombination.getCombinationCards();

        assertThat(cards.size(), is(equalTo(2)));
    }

    @Test
    public void shouldReturnNameFromCombination() {
        assertThat(cardCombination.getCombinationName(), is(equalTo(BEST_CARD.toString())));
    }

    @Test
    public void shouldReturnedTheSeniorCard() {
        Card kicker = cardCombination.getKicker();

        assertThat(kicker.getRange(), is(equalTo(TEN)));
    }
}