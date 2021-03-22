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

    public ActivityModel  CreateActivity(ActivityModel activityModel)
    {
        List<TimeSlotModel> timeslots = iTimeSlotRepository.findAll();
        for(TimeSlotModel t : timeslots)
        {
            activityModel.getTimeSlotModelSet().add(t);
            iActivityRepository.save(activityModel);

            t.getActivityModelSet().add(activityModel);
            iTimeSlotRepository.save(t);
        }
     return activityModel;
    }

    public List<ActivityModel> getAllActivities()
    {
        return iActivityRepository.findAll();
    }

    public ActivityModel updateActivity(ActivityModel activityModel) {return iActivityRepository.save(activityModel);}

    //public ActivityModel deleteActivity(ActivityModel activityModel) {return IActivityRepository.deleteByID(activityModel);}

}
