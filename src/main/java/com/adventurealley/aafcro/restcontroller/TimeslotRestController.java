package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeslotRestController
{
    @Autowired
    ITimeSlotRepository timeSlotRepository;

    @GetMapping("/findAllTimeslots")
    private List<TimeSlotModel> findAllTimeSlots()
    {
        return timeSlotRepository.findAll();
    }

    @GetMapping("/timeslotForBooking/{bookingId}")
    TimeSlotModel timeslotForBooking(@PathVariable Long bookingId)
    {
       return timeSlotRepository.timeslotForBooking(bookingId);
    }
}
