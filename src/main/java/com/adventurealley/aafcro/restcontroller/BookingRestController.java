package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.*;
import com.adventurealley.aafcro.service.ActivityService;
import com.adventurealley.aafcro.service.BookingService;
import com.adventurealley.aafcro.service.TimeslotService;
import com.adventurealley.aafcro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingRestController
{
    @Autowired
    BookingService bookingService;

    @Autowired
    ActivityService activityService;

    @Autowired
    TimeslotService timeslotService;

    @Autowired
    UserService userService;

    @GetMapping("/findAllBookings")
    public List<BookingModel> findAllBookings()
    {
        return bookingService.findAll();
    }

    @PostMapping("/postBooking")
    @ResponseStatus(HttpStatus.CREATED)
    Exception postBooking(@RequestBody BookingModel booking)
    {
         return bookingService.createBooking(booking);
    }

    @GetMapping("/bookingsForCurrentUser")
    public List<BookingModel> bookingsForUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookingService.getBookingsToUser(authentication.getName());
    }

    @GetMapping("/getBookingsForCurrentUserCalendar")
    public List<String> getBookingsForUser()
    {
        return bookingService.getBookingsForUserCalendar();
    }

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteBooking/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId)
    {
        try
        {
            bookingService.deleteById(bookingId);
        }
        catch (EmptyResultDataAccessException e)
        {
            System.out.println("Error..... " + e.getMessage());
        }
    }

    @PutMapping(value = "/updateTimeslotForBooking", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateBooking(@RequestBody BookingModel updatedBooking)
    {
         bookingService.updateBooking(updatedBooking);
    }

    @GetMapping("/findAllBookingsForAllUsers")
    public List<ActivityBookingDTO> findAllBookingsForAllUsers()
    {
        return bookingService.findAllBookingsForAllUsers();
    }
}
