package com.adventurealley.aafcro.controller;

import com.adventurealley.aafcro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController
{
    @Autowired
    LoginService loginService;

    @GetMapping("/logout-success")
    public String getLogout()
    {
        return "logout";
    }

    @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }
}
