package com.adventurealley.aafcro.restcontroller;

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

    @GetMapping("/findAllActivities")
    public List<ActivityModel> findAllActivities()
    {
        return activityService.getAllActivities();
    }

    @PostMapping(value = "/newActivity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityModel postActivity(@RequestBody ActivityModel activityModel)
    {
        return activityService.CreateActivity(activityModel);
    }

    @PutMapping(value = "/updateActivity")
    public ActivityModel putActivity(@RequestBody ActivityModel activity) {
        return activityService.updateActivity(activity);
    }
}
