package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }

    @GetMapping("/error")
    public String getError()
    {
        return "error";
    }

    @GetMapping("/logout-success")
    public String getLogout()
    {
        return "logout";
    }
}
