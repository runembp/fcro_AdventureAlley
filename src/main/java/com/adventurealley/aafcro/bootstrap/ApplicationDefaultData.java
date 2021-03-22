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

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
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

/*
            ActivityModel a1 = new ActivityModel("Paintball", "Dette er sjovt", 150.00, null,  null, "Sikkerhedstøj");
            activityRepository.save(a1);
            ActivityModel a2 = new ActivityModel("Sumobrydning", "Rune vinder sikkert", 100.00, null, null, "Sumodragt");
            activityRepository.save(a2);

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

            timeSlotRepository.save(t1);
            timeSlotRepository.save(t2);
            timeSlotRepository.save(t3);
            timeSlotRepository.save(t4);

            UserModel u1 = new UserModel("rbp@groupcare.com", "0012", "Rune", "Petersen", LocalDate.parse("1984-10-08"), 170);
            userRepository.save(u1);

            BookingModel b1 = new BookingModel(LocalDate.now());
            BookingModel b2 = new BookingModel(LocalDate.now());
            b1.setUsers(u1);
            b2.setUsers(u1);
            b1.setActivity(a1);
            b2.setActivity(a2);
            b1.setTimeSlot(t1);
            b2.setTimeSlot(t4);
            bookingRepository.save(b1);
            bookingRepository.save(b2);

            a1.getBookings().add(b1);
            a2.getBookings().add(b2);
            activityRepository.save(a1);
            activityRepository.save(a2);

            u1.getBookingSet().add(b1);
            u1.getBookingSet().add(b2);

            userRepository.save(u1);*/


            //Ny User
            UserModel rune = new UserModel("rbp@groupcare.com", "0012", "Rune", "Petersen", LocalDate.parse("1984-10-08"), 170);
            userRepository.save(rune);


            BookingModel b = new BookingModel(LocalDate.now());
            bookingRepository.save(b);

            ActivityModel a = new ActivityModel("Paintball", "Dette er sjovt", 150.00, null,  null, "Sikkerhedstøj");

            a.getTimeSlotModelSet().add(t1);
            a.getBookings().add(b);
            activityRepository.save(a);

            b.setTimeSlot(t1);
            b.setActivity(a);
            b.setUsers(rune);
            bookingRepository.save(b);

            t1.getActivityModelSet().add(a);
            t1.getBookings().add(b);
            timeSlotRepository.save(t1);

            rune.getBookingSet().add(b);
            userRepository.save(rune);
//--------------------------------------------

            BookingModel b1 = new BookingModel(LocalDate.now());
            bookingRepository.save(b1);

            ActivityModel a1 = new ActivityModel("Sumobrydning", "Rune vinder sikkert", 100.00, null, null, "Sumodragt");

            a1.getTimeSlotModelSet().add(t3);
            a1.getBookings().add(b1);
            activityRepository.save(a1);

            b1.setTimeSlot(t3);
            b1.setActivity(a1);
            b1.setUsers(rune);
            bookingRepository.save(b1);

            t3.getActivityModelSet().add(a1);
            t3.getBookings().add(b1);
            timeSlotRepository.save(t3);

            rune.getBookingSet().add(b1);
            userRepository.save(rune);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
