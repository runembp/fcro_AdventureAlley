package com.adventurealley.aafcro.controller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.service.LoginService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        var password = data.getParameter("password");

        if(loginService.isUserAuthenticated(email,password))
        {
            return "redirect:/loggedin/"+email;
        }

        return "redirect:/";
    }

    @GetMapping("/loggedin/{email}")
    public String getLoggedIn()
    {
        return "loggedin/index";
    }
}
