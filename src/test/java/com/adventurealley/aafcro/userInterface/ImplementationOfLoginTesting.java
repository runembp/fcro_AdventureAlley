package com.adventurealley.aafcro.userInterface;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ImplementationOfLoginTesting
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    LoginService loginService;

    @Test
    void TestLoginMapping() throws Exception
    {
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(content().string(containsString("Login")));
    }

    @Test
    void createNewUser()
    {
        var user = new UserModel("test@testesen.dk","1234","Test","Testesen",LocalDate.parse("2021-10-02"),130);

        loginService.createNewUser(user);
        var userFromService = loginService.getUserByEmail("test@testesen.dk");

        assertEquals(user,userFromService);
    }
}
