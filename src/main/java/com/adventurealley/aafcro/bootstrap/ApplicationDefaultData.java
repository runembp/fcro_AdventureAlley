package com.adventurealley.aafcro.bootstrap;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import com.adventurealley.aafcro.repository.IBookingRepository;
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

    @Autowired
    IActivityRepository activityRepository;

    @Autowired
    IBookingRepository bookingRepository;

    @Override
    public void run(ApplicationArguments args)
    {
        try{

            TimeSlotModel t1 = new TimeSlotModel("08:00", "10:00");
            timeSlotRepository.save(t1);
            TimeSlotModel t2 = new TimeSlotModel("10:00", "12:00");
            timeSlotRepository.save(t2);
            TimeSlotModel t3 = new TimeSlotModel("12:00", "14:00");
            timeSlotRepository.save(t3);
            TimeSlotModel t4 = new TimeSlotModel("14:00", "16:00");
            timeSlotRepository.save(t4);

            ActivityModel a1 = new ActivityModel("GoKart", "Dette er sjovt", 399.99, 140,  16, "Hjelm");
            activityRepository.save(a1);
            ActivityModel a2 = new ActivityModel("MiniGolf", "Rune vinder sikkert", 99.99, 0, 0, "Kølle og bold");
            activityRepository.save(a2);
            ActivityModel a3 = new ActivityModel("Pantball", "Rune vinder sikkert", 349.99, 0, 16, "Paintball gevær");
            activityRepository.save(a3);
            ActivityModel a4 = new ActivityModel("Sumo Wrestling", "Rune vinder sikkert", 99.99, 140, 12, "Sumodragt");
            activityRepository.save(a4);

            t1.getActivityModelSet().add(a1);
            t2.getActivityModelSet().add(a1);
            t3.getActivityModelSet().add(a1);
            t4.getActivityModelSet().add(a1);
            a1.getTimeSlotModelSet().add(t1);
            a1.getTimeSlotModelSet().add(t2);
            a1.getTimeSlotModelSet().add(t3);
            a1.getTimeSlotModelSet().add(t4);

            timeSlotRepository.save(t1);
            timeSlotRepository.save(t2);
            timeSlotRepository.save(t3);
            timeSlotRepository.save(t4);

            t1.getActivityModelSet().add(a2);
            t2.getActivityModelSet().add(a2);
            t3.getActivityModelSet().add(a2);
            t4.getActivityModelSet().add(a2);
            a2.getTimeSlotModelSet().add(t1);
            a2.getTimeSlotModelSet().add(t2);
            a2.getTimeSlotModelSet().add(t3);
            a2.getTimeSlotModelSet().add(t4);

            activityRepository.save(a2);
            timeSlotRepository.save(t1);
            timeSlotRepository.save(t2);
            timeSlotRepository.save(t3);
            timeSlotRepository.save(t4);

            UserModel u1 = new UserModel("rbp@groupcare.com", "0012", "Rune", "Petersen", LocalDate.parse("1984-10-08"), 170);
            userRepository.save(u1);

            BookingModel b1 = new BookingModel(LocalDate.now(),1L,a1);
            bookingRepository.save(b1);
            a1.getBookings().add(b1);
            activityRepository.save(a1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
