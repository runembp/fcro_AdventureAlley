package com.adventurealley.aafcro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class BookingController
{
    @GetMapping("/loggedin/bookings/{email}")
    public String getBookings()
    {
        return "loggedin/bookings";
    }

    @GetMapping("/loggedin/booking_calendar/{email}")
    public String getBookingCalendar()
    {
        return "loggedin/booking_calendar";
    }

    @PostMapping("loggedin/postCalendar")
    public String postCalendar(WebRequest data)
    {
        String email = data.getParameter("postCalendar");

        return "redirect:/loggedin/booking_calendar/"+email;
    }
}
