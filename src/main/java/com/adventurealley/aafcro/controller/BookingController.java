package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class BookingController
{
    @GetMapping("/loggedin/bookings/{email}")
    public String getBookings()
    {
        return "loggedin/bookings";
    }

    @GetMapping("/loggedin/booking_calendar")
    public String getBookingCalendar(WebRequest data)
    {
        return "loggedin/booking_calendar";
    }
}
