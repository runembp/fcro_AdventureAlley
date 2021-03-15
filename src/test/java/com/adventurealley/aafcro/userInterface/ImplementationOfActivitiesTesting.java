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
        ActivityModel activityModel = new ActivityModel("UnittestActivity", "Des: unittest", 130, 16, "Hjelm");

        iActivityRepository.save(activityModel);

        ActivityModel activityModel1 = iActivityRepository.findById(activityModel.getActivity_id()).get();


        assertEquals(activityModel, activityModel1);

    }

}
