package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController
{
    @GetMapping("/loggedin")
    public String getBookings()
    {
        return "loggedin/bookings";
    }

    @GetMapping("/loggedin/booking_calendar")
    public String getBookingCalendar()
    {
        return "loggedin/booking_calendar";
    }
}
