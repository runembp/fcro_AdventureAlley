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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @PostMapping(value = "/postBooking", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    BookingModel postBooking(@RequestBody BookingModel booking)
    {
        UserModel user = new UserModel("rbp@groupcare.com", "0012", "Rune", "Petersen", LocalDate.parse("1984-10-08"), 170);
        userRepository.save(user);

        //Brugeren skal trækkes fra js og insættes som i linje 65.

        if(activityRepository.findById(booking.getDummy()).isEmpty())
        {
            return null;
        }

        ActivityModel activityModel = activityRepository.findById(booking.getDummy()).get();
        TimeSlotModel timeSlotModel = timeSlotRepository.findById(booking.getDummyTimeSlot()).get();

        activityModel.getBookings().add(booking);
        timeSlotModel.getBookings().add(booking);

        booking.setActivity(activityModel);
        booking.setTimeSlot(timeSlotModel);
        booking.setUsers(user);

        return bookingRepository.save(booking);
    }



}
