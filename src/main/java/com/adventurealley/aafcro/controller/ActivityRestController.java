package com.adventurealley.aafcro.controller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityRestController {

    @Autowired
    private ActivityService activityService;

    @PostMapping(value = "/newActivity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityModel postActivity(@RequestBody ActivityModel activityModel)
    {
        return activityService.CreateActivity(activityModel);
    }

    @GetMapping("/findAllActivities")
    public List<ActivityModel> findAllActivities()
    {
        return activityService.getAllActivities();
    }


}
