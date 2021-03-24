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

            ActivityModel a1 = new ActivityModel("GoKart", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.", 399.99, 140,  16, "Hjelm", "https://images.pexels.com/photos/861464/pexels-photo-861464.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            activityRepository.save(a1);
            ActivityModel a2 = new ActivityModel("MiniGolf", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.", 99.99, 0, 0, "Kølle og bold", "https://images.pexels.com/photos/6370072/pexels-photo-6370072.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            activityRepository.save(a2);
            ActivityModel a3 = new ActivityModel("Paintball", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.", 349.99, 0, 16, "Paintball gevær", "https://images.unsplash.com/photo-1588432892836-99b9aa3feb8a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
            activityRepository.save(a3);
            ActivityModel a4 = new ActivityModel("Sumo Wrestling", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.", 99.99, 140, 12, "Sumodragt", "https://images.unsplash.com/photo-1574908445051-d9e0c2f4f763?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
            activityRepository.save(a4);

            t1.getActivityModelSet().add(a1);
            t2.getActivityModelSet().add(a1);
            t3.getActivityModelSet().add(a1);
            t4.getActivityModelSet().add(a1);
            a1.getTimeslot().add(t1);
            a1.getTimeslot().add(t2);
            a1.getTimeslot().add(t3);
            a1.getTimeslot().add(t4);

            timeSlotRepository.save(t1);
            timeSlotRepository.save(t2);
            timeSlotRepository.save(t3);
            timeSlotRepository.save(t4);

            t1.getActivityModelSet().add(a2);
            t2.getActivityModelSet().add(a2);
            t3.getActivityModelSet().add(a2);
            t4.getActivityModelSet().add(a2);
            a2.getTimeslot().add(t1);
            a2.getTimeslot().add(t2);
            a2.getTimeslot().add(t3);
            a2.getTimeslot().add(t4);

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
            UserModel admin = new UserModel("admin@adventurealley.com", "admin", "Admin", "Adminsson", LocalDate.parse("2021-01-01"), 100);
            userRepository.save(admin);
            b1.setActivity(a1);
            b2.setActivity(a2);
            b1.setTimeSlot(t1);
            b2.setTimeSlot(t4);
            bookingRepository.save(b1);
            bookingRepository.save(b2);

            activityRepository.save(a1);
            activityRepository.save(a2);

            u1.getBookingSet().add(b1);
            u1.getBookingSet().add(b2);

            userRepository.save(u1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
