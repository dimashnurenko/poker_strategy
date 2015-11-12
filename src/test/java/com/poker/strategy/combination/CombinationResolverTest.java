package com.poker.strategy.combination;

import com.poker.strategy.model.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static com.poker.strategy.model.Range.*;
import static com.poker.strategy.model.Suit.CROSS;
import static com.poker.strategy.model.Suit.DIAMONDS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class CombinationResolverTest {

    private static final String FLESH_COMBINATION_CODE            = "2C 3D JC 5P QC AC 9C";
    private static final String ERROR_SUIT_CODE_IN_COMBINATION    = "2C 3D JC 5P QC AC 9M";
    private static final String ERROR_RANGE_CODE_IN_COMBINATION   = "LC 3D JC 5P QC AC 9M";
    private static final String ERROR_RANGE_CODE_IN_COMBINATION_2 = "5CC 3D JC 5P QC AC 9M";

    private final Rules rules = new SimpleCodeRule();

    private CombinationResolver resolver = new CombinationResolver(rules);

    @Test
    public void combinationShouldBeResolvedUsingCorrectCode() {
        Set<Card> cards = resolver.resolve(FLESH_COMBINATION_CODE);

        assertThat(cards.size(), is(equalTo(7)));
        assertThat(cards.contains(new Card(TWO, CROSS)), is(true));
        assertThat(cards.contains(new Card(ACE, CROSS)), is(true));
        assertThat(cards.contains(new Card(JACK, CROSS)), is(true));
        assertThat(cards.contains(new Card(NINE, DIAMONDS)), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrownWhenResolveErrorCombinationSuitCode() {
        resolver.resolve(ERROR_SUIT_CODE_IN_COMBINATION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrownWhenResolveErrorCombinationRangeCode() {
        resolver.resolve(ERROR_RANGE_CODE_IN_COMBINATION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrownDuringResolveInvalidCombinationSymbolsCount() {
        resolver.resolve(ERROR_RANGE_CODE_IN_COMBINATION_2);
    }
}