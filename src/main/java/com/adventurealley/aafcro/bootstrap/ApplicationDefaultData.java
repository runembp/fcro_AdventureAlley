package com.adventurealley.aafcro.bootstrap;

import com.adventurealley.aafcro.authorization.AuthGroupModel;
import com.adventurealley.aafcro.authorization.IAuthGroupRepository;
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

    @Autowired
    IAuthGroupRepository authGroupRepository;

    @Override
    public void run(ApplicationArguments args)
    {
        try{
/*
            TimeSlotModel t1 = new TimeSlotModel("08:00", "10:00");
            timeSlotRepository.save(t1);
            TimeSlotModel t2 = new TimeSlotModel("10:00", "12:00");
            timeSlotRepository.save(t2);
            TimeSlotModel t3 = new TimeSlotModel("12:00", "14:00");
            timeSlotRepository.save(t3);
            TimeSlotModel t4 = new TimeSlotModel("14:00", "16:00");
            timeSlotRepository.save(t4);

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
*/
            UserModel u1 = new UserModel("rbp@groupcare.com", "$2a$09$dKC/C1ybG8FF.LOeNLGSu.ZXPcqM3UAKeajg0YFjsarHTcY7wLmXK", "Rune", "Petersen", LocalDate.parse("1984-10-08"), 170);
            userRepository.save(u1);

            AuthGroupModel ag1 = new AuthGroupModel("rbp@groupcare.com","USER");
            authGroupRepository.save(ag1);

            AuthGroupModel ag2 = new AuthGroupModel("rbp@groupcare.com","ADMIN");
            authGroupRepository.save(ag2);

/*
            BookingModel b1 = new BookingModel(LocalDate.now(),1L);
            BookingModel b2 = new BookingModel(LocalDate.now(),1L);
            b1.setActivity(a1);
            b2.setActivity(a2);
            bookingRepository.save(b1);
            bookingRepository.save(b2);

            a1.getBookings().add(b1);
            a2.getBookings().add(b2);
            activityRepository.save(a1);
            activityRepository.save(a2);
        */
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
