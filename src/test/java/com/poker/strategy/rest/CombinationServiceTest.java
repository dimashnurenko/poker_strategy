package com.poker.strategy.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitry Shnurenko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/poker-strategy-servlet.xml"})
@WebAppConfiguration
public class CombinationServiceTest {

    private static final String DEFINE_COMBINATION_URL = "/combination/define";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void combinationShouldBeReturnedByTheCode() throws Exception {
        String expectedCombination = "STREET";

        MvcResult result = mockMvc.perform(sendGetRequestToDefineCombination(DEFINE_COMBINATION_URL,
                                                                             "2C 3P 4D 5C 6P JP AD"))
                                  .andExpect(status().is(200))
                                  .andReturn();

        String returnedContent = result.getResponse().getContentAsString();

        assertThat(returnedContent, is(equalTo(expectedCombination)));
    }

    private MockHttpServletRequestBuilder sendGetRequestToDefineCombination(String url, String combinationCode) {
        return get(url + "/" + combinationCode).header("host", "localhost:80");
    }

    @Test
    public void illegalArgumentExceptionShouldBeThrownSomethingHappensDuringRequestExecution() throws Exception {
        mockMvc.perform(sendGetRequestToDefineCombination(DEFINE_COMBINATION_URL, "1C 54D 92 63"))
               .andExpect(status().is(500));
    }

}