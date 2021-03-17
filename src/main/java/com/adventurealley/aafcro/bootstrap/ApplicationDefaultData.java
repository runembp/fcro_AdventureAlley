package com.adventurealley.aafcro.bootstrap;

import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class ApplicationDefaultData implements ApplicationRunner
{

    @Autowired
    ITimeSlotRepository timeSlotRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        try{

            TimeSlotModel t1 = new TimeSlotModel("8:00", "10:00");
            timeSlotRepository.save(t1);
            TimeSlotModel t2 = new TimeSlotModel("10:00", "12:00");
            timeSlotRepository.save(t2);
            TimeSlotModel t3 = new TimeSlotModel("12:00", "14:00");
            timeSlotRepository.save(t3);
            TimeSlotModel t4 = new TimeSlotModel("14:00", "16:00");
            timeSlotRepository.save(t4);

            UserModel u1 = new UserModel("rbp@groupcare.com", "0012", "Rune", "Petersen", LocalDate.parse("1984-10-08"), 170);
            userRepository.save(u1);
        }
        catch (Exception e)
        {
            System.out.println("Error in: " + "ApplicationDefaultData" + e.getMessage());
        }
    }
}
