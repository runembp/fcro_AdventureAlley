package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeslotService
{
    @Autowired
    ITimeSlotRepository timeSlotRepository;

    public TimeSlotModel findById(Long id)
    {
        return timeSlotRepository.findById(id).get();
    }

    public void save(TimeSlotModel timeSlotModel)
    {
        timeSlotRepository.save(timeSlotModel);
    }

    public List<TimeSlotModel> findAll()
    {
        return timeSlotRepository.findAll();
    }

    public TimeSlotModel timeslotForBooking(Long bookingId)
    {
        return timeSlotRepository.timeslotForBooking(bookingId);
    }
}
