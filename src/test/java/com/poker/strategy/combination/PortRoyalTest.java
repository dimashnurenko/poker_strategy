package com.poker.strategy.combination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.poker.strategy.combination.CombinationType.PORT_ROYAL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(MockitoJUnitRunner.class)
public class PortRoyalTest {

    @Test
    public void portRoyalTypeShouldBeReturned() {
        PortRoyal portRoyal = new PortRoyal(new HashSet<>());

        assertThat(portRoyal.getCombinationType(), equalTo(PORT_ROYAL));
    }
}