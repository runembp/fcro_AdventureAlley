package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityService
{
    @Autowired
    private IActivityRepository iActivityRepository;

    public void CreateActivity(String title, String description, Double price, Integer min_height, Integer min_age, String equipment){
        ActivityModel activityModel = new ActivityModel(title, description, price, min_height, min_age, equipment);
        iActivityRepository.save(activityModel);
    }

}
