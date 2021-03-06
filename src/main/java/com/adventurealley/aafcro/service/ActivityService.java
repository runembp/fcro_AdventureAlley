package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService
{
    @Autowired
    private IActivityRepository iActivityRepository;

    @Autowired
    private ITimeSlotRepository iTimeSlotRepository;

    public void  CreateActivity(ActivityModel activityModel)
    {
        List<TimeSlotModel> timeslots = iTimeSlotRepository.findAll();
        for(TimeSlotModel t : timeslots)
        {
            activityModel.getTimeslot().add(t);
            iActivityRepository.save(activityModel);

            t.getActivityModelSet().add(activityModel);
            iTimeSlotRepository.save(t);
        }
    }

    public List<ActivityModel> getAllActivities()
    {
        return iActivityRepository.findAll();
    }

    public void updateActivity(ActivityModel activityModel)
    {
        iActivityRepository.save(activityModel);
    }

    public void deleteActivityByID(Long activityId) {
        iActivityRepository.deleteById(activityId);
    }

    public ActivityModel getActivityToBooking(Long bookingId)
    {
        return iActivityRepository.getActivityToBooking(bookingId);
    }

    public ActivityModel findById(Long id)
    {
        return iActivityRepository.findById(id).get();
    }

    public ActivityModel save(ActivityModel activityModel)
    {
        return iActivityRepository.save(activityModel);
    }
}
