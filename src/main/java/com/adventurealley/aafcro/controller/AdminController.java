package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminCreateActivity")
    public String createActivity(){
        return "admin/admin_create_activity";
    }

    @GetMapping("/admin")
    public String getOverview(){ return "admin/admin_overview"; }

}
