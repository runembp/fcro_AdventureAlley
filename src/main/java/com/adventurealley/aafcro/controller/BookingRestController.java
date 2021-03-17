package com.adventurealley.aafcro.controller;

import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingRestController
{
    @Autowired
    IBookingRepository bookingRepository;

    @GetMapping("/findAllBookings")
    public List<BookingModel> findAllBookings()
    {
        return bookingRepository.findAll();
    }
}
