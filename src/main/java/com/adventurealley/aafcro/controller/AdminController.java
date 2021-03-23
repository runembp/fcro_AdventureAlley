package com.adventurealley.aafcro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminCRUD")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createActivity(){
        return "/admin/admin_crud_activity";
    }

}
