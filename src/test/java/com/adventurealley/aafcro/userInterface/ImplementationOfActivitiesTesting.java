package com.adventurealley.aafcro.userInterface;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImplementationOfActivitiesTesting {

    @Autowired
    IActivityRepository iActivityRepository;

    @Test
    public void CreateActivity()
    {
        ActivityModel activityModel2 = new ActivityModel("UnittestActivity", "Des: unittest", 150.00, null, null, null, null);
        iActivityRepository.save(activityModel2);

        ActivityModel activityModel1 = iActivityRepository.findById(activityModel2.getActivityId()).get();

        assertEquals(activityModel2, activityModel1);
    }

}
