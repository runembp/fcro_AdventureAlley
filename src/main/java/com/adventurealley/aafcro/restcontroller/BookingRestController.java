package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import com.adventurealley.aafcro.repository.IBookingRepository;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping(value = "/postBooking", consumes = "application/json")
    BookingModel postBooking(@RequestBody BookingModel booking)
    {
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

        return bookingRepository.save(booking);
    }
}
