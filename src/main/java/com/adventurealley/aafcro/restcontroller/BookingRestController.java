package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import com.adventurealley.aafcro.repository.IBookingRepository;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingRestController
{
    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    IActivityRepository activityRepository;

    @Autowired
    ITimeSlotRepository timeSlotRepository;

    @GetMapping("/findAllBookings")
    public List<BookingModel> findAllBookings()
    {
        return bookingRepository.findAll();
    }

    @Autowired
    IUserRepository userRepository;

    @PostMapping(value = "/postBooking/{email}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    BookingModel postBooking(@RequestBody BookingModel booking, @PathVariable String email)
    {
        UserModel user = userRepository.findUserByEmail(email); //Denne virker

        BookingModel newBooking = bookingRepository.save(booking);
        bookingRepository.save(newBooking);

        TimeSlotModel timeSlotModel = timeSlotRepository.findById(booking.getDummyTimeSlot()).get();
        timeSlotRepository.save(timeSlotModel);

        ActivityModel activityModel = activityRepository.findById(booking.getDummy()).get();
        activityModel.getTimeslot().add(timeSlotModel);
        activityModel.getBookingsSet().add(newBooking);
        activityRepository.save(activityModel);

        newBooking.setUsers(user);
        newBooking.setActivity(activityModel);
        newBooking.setTimeSlot(timeSlotModel);
        bookingRepository.save(newBooking);

        timeSlotModel.getActivityModelSet().add(activityModel);
        timeSlotModel.getBookings().add(newBooking);
        timeSlotRepository.save(timeSlotModel);

        user.getBookingSet().add(newBooking);
        userRepository.save(user);

        return bookingRepository.save(newBooking);
    }

    @GetMapping("/bookings/{email}")
    public List<BookingModel> bookingsForUser(@PathVariable String email)
    {
        return bookingRepository.getBookingsToUser(email);
    }

    @GetMapping("/getBookingsForUser/{userEmail}")
    public List<String> getBookingsForUser(@PathVariable String userEmail)
    {
        return bookingRepository.getBookingsForUser(userEmail);
    }

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteBooking/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId)
    {
        try{
            bookingRepository.deleteById(bookingId);
        }catch (EmptyResultDataAccessException e)
        {
            System.out.println("Error..... " + e.getMessage());
        }
    }



}
