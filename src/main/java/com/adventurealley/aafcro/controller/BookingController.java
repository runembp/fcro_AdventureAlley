package com.adventurealley.aafcro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController
{
    @GetMapping("/loggedin/bookings")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getBookings()
    {
        return "loggedin/bookings";
    }
}
