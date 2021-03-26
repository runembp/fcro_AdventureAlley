package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ActivityRestController
{
    @Autowired
    private ActivityService activityService;

    @GetMapping("/findAllActivities")
    public List<ActivityModel> findAllActivities()
    {
        return activityService.getAllActivities();
    }

    @PostMapping(value = "/newActivity", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void postActivity(@RequestBody ActivityModel activityModel)
    {
        activityService.CreateActivity(activityModel);
    }

    @PutMapping(value = "/updateActivity", consumes = "application/json")
    public void putActivity(@RequestBody ActivityModel updatedActivity)
    {
        activityService.updateActivity(updatedActivity);
    }

    @DeleteMapping("/deleteActivity/{activityId}")
    public void deleteActivity(@PathVariable Long activityId)
    {
        activityService.deleteActivityByID(activityId);
    }

    @GetMapping("/getActivityToBooking/{bookingId}")
    public ActivityModel findActivityForBooking(@PathVariable Long bookingId)
    {
        return activityService.getActivityToBooking(bookingId);
    }
}
