package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.STREET;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class StreetTest {

    @Test
    public void streetTypeShouldBeReturned() {
        Street street = new Street(new HashSet<>());

        assertThat(street.getCombinationType(), equalTo(STREET));
    }
}