package com.adventurealley.aafcro.userInterface;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.adventurealley.aafcro.controller.IndexController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Test for at kunne hente forside
 * Mob development - TDD
 */

@SpringBootTest
@AutoConfigureMockMvc //Simmulerer controller
public class UITest
{
    @Autowired
    private IndexController indexController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testIndexAccess() throws Exception
    {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString( "Adventure Alley")));
    }








}
