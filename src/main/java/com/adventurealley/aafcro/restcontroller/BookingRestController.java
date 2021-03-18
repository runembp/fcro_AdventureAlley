package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping("findAllBookingsByActivity/{id}")
    public Set<BookingModel> findAllBookingsByActivity(@PathVariable Long id)
    {
        return bookingRepository.findAllBookingsForActivity(id);
    }

    @PostMapping(value = "/postBooking", consumes = "application/json")
    BookingModel postBooking(@RequestBody BookingModel booking)
    {
        return bookingRepository.save(booking);
    }
}
