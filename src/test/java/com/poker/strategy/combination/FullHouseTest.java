package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.FULL_HOUSE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class FullHouseTest {

    @Test
    public void fullHouseTypeShouldBeReturned() {
        FullHouse fullHouse = new FullHouse(new HashSet<>());

        assertThat(fullHouse.getCombinationType(), equalTo(FULL_HOUSE));
    }
}