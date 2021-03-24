package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeslotRestController
{
    @Autowired
    TimeslotService timeslotService;

    @GetMapping("/findAllTimeslots")
    private List<TimeSlotModel> findAllTimeSlots()
    {
        return timeslotService.findAll();
    }

    @GetMapping("/timeslotForBooking/{bookingId}")
    TimeSlotModel timeslotForBooking(@PathVariable Long bookingId)
    {
       return timeslotService.timeslotForBooking(bookingId);
    }
}
