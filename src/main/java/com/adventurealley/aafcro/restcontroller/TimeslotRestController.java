package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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
