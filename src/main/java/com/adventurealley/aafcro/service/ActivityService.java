package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService
{
    @Autowired
    private IActivityRepository iActivityRepository;

    public ActivityModel CreateActivity(ActivityModel activityModel)
    {
        return iActivityRepository.save(activityModel);
    }

    public List<ActivityModel> getAllActivities()
    {
        return iActivityRepository.findAll();
    }

}
