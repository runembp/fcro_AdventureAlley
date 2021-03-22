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


//    @GetMapping("/login")
//    public String getLogin()
//    {
//        return "login";
//    }
//
//
//    @PostMapping("/postlogin")
//    public String postLogin(WebRequest data)
//    {
//
//        String email = data.getParameter("email");
//        var password = data.getParameter("password");
//
//        if(loginService.isUserAuthenticated(email,password))
//        {
//            return "redirect:/loggedin/"+email;
//        }
//
//        return "redirect:/";
//    }
//    @GetMapping("/loggedin/{email}")
//    public String getLoggedIn()
//    {
//        return "loggedin/index";
//    }
}
