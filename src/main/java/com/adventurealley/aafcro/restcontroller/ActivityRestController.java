package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
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

    @PutMapping(value = "/updateActivity", consumes = "application/json")
    public ActivityModel putActivity(@RequestBody ActivityModel updatedActivity) {
        return activityService.updateActivity(updatedActivity);
    }

    @DeleteMapping("/deleteActivity/{activityId}")
    public void deleteActivity(@PathVariable Integer activityId) {
        
    }
}
