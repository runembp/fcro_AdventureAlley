package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController
{
    @GetMapping("/createuser")
    public String getCreate()
    {
        return "create_user";
    }
}
