package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController
{
    @GetMapping("/loggedin/bookings")
    public String getBookings()
    {
        return "loggedin/bookings";
    }
}
