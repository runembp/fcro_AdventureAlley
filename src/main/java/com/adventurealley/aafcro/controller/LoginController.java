package com.adventurealley.aafcro.controller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.service.LoginService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;


@Controller
public class LoginController
{
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }


    @PostMapping("/postlogin")
    public String postLogin(WebRequest data)
    {

        String email = data.getParameter("email");
        String password = data.getParameter("password");

        if(loginService.isUserAuthenticated(email,password))
        {
            return "redirect:/loggedin/"+email;
        }

        return "redirect:/";
    }

    @GetMapping("/loggedin/{email}")
    public String getLoggedIn(@PathVariable String email)
    {
        return "redirect:/loggedin/bookings/"+email;
    }
}
