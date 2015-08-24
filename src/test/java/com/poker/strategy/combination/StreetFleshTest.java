package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.STREET_FLESH;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class StreetFleshTest {

    @Test
    public void streetFleshTypeShouldBeReturned() {
        StreetFlesh streetFlesh = new StreetFlesh(new HashSet<>());

        assertThat(streetFlesh.getCombinationType(), equalTo(STREET_FLESH));
    }

}