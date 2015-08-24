package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

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
        Square square = new Square(new HashSet<>());

        assertThat(square.getCombinationType(), equalTo(SQUARE));
    }
}