package com.poker.strategy.combination;

import com.poker.strategy.model.Range;
import com.poker.strategy.model.Suit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static com.poker.strategy.model.Range.*;
import static com.poker.strategy.model.Suit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleCodeRuleTest {

    private static final int COUNT_RANGES_IN_DECK = 13;
    private static final int COUNT_SUITS_IN_DECK  = 4;

    @InjectMocks
    private SimpleCodeRule rule;

    @Test
    public void predefinedRangeRulesShouldBeReturned() {
        Map<String, Range> rangeRules = rule.getRangeRules();

        assertThat(rangeRules.size(), is(equalTo(COUNT_RANGES_IN_DECK)));

        assertThat(rangeRules.get("2"), is(equalTo(TWO)));
        assertThat(rangeRules.get("3"), is(equalTo(THREE)));
        assertThat(rangeRules.get("4"), is(equalTo(FOUR)));
        assertThat(rangeRules.get("5"), is(equalTo(FIVE)));
        assertThat(rangeRules.get("6"), is(equalTo(SIX)));
        assertThat(rangeRules.get("7"), is(equalTo(SEVEN)));
        assertThat(rangeRules.get("8"), is(equalTo(EIGHT)));
        assertThat(rangeRules.get("9"), is(equalTo(NINE)));
        assertThat(rangeRules.get("T"), is(equalTo(TEN)));
        assertThat(rangeRules.get("J"), is(equalTo(JACK)));
        assertThat(rangeRules.get("Q"), is(equalTo(QUEEN)));
        assertThat(rangeRules.get("K"), is(equalTo(KING)));
        assertThat(rangeRules.get("A"), is(equalTo(ACE)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unsupportedOperationExceptionShouldBeThrownWhenTryToChangeMapWithRangeRules() {
        Map<String, Range> rangeRules = rule.getRangeRules();

        rangeRules.put("someX", NINE);
    }

    @Test
    public void predefinedSuitRulesShouldBeReturned() {
        Map<String, Suit> suitRules = rule.getSuitRules();

        assertThat(suitRules.size(), is(equalTo(COUNT_SUITS_IN_DECK)));

        assertThat(suitRules.get("C"), is(equalTo(CROSS)));
        assertThat(suitRules.get("H"), is(equalTo(HEARTS)));
        assertThat(suitRules.get("D"), is(equalTo(DIAMONDS)));
        assertThat(suitRules.get("P"), is(equalTo(PEAK)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unsupportedOperationExceptionShouldBeThrownWhenTryToChangeMapWithSuitRules() {
        Map<String, Suit> suitRules = rule.getSuitRules();

        suitRules.put("someX", CROSS);
    }
}