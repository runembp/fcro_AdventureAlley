package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController
{
    @GetMapping("/adminCRUD")
    public String createActivity()
    {
        return "/admin/admin_crud_activity";
    }

    @GetMapping("/admin/overview")
    public String getAdminOverview()
    {
        return "/admin/admin_booking_overview";
    }
}
