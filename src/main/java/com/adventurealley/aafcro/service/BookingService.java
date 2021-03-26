package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService
{
    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    ActivityService activityService;

    @Autowired
    TimeslotService timeslotService;

    @Autowired
    UserService userService;

    public List<BookingModel> findAll()
    {
        return bookingRepository.findAll();
    }

    public BookingModel save(BookingModel booking)
    {
        return bookingRepository.save(booking);
    }

    public List<BookingModel> getBookingsToUser(String userMail)
    {
        return bookingRepository.getBookingsToUser(userMail);
    }

    public List<String> getBookingsForUserCalendar()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookingRepository.getBookingsForUser(authentication.getName());
    }

    public void deleteById(Long bookingId)
    {
        bookingRepository.deleteById(bookingId);
    }

    public Exception createBooking(BookingModel booking) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userService.findUserByEmail();

        List<BookingModel> userBookingList = getBookingsToUser(authentication.getName());

        try
        {
            for(var x : userBookingList)
            {
                if(x.getBookingDate().equals(booking.getBookingDate()) && x.getTimeSlot().getTimeSlotId().equals(booking.getDummyTimeSlot()))
                {
                    throw new Exception("ERROR");
                }
            }
        }
        catch (Exception e)
        {
            return e;
        }

        BookingModel newBooking = save(booking);
        save(newBooking);


        TimeSlotModel timeSlotModel = timeslotService.findById(booking.getDummyTimeSlot());
        timeslotService.save(timeSlotModel);

        ActivityModel activityModel = activityService.findById(booking.getDummy());
        activityModel.getTimeslot().add(timeSlotModel);
        activityModel.getBookingsSet().add(newBooking);
        activityService.save(activityModel);

        newBooking.setUsers(user);
        newBooking.setActivity(activityModel);
        newBooking.setTimeSlot(timeSlotModel);
        save(newBooking);

        timeSlotModel.getActivityModelSet().add(activityModel);
        timeSlotModel.getBookings().add(newBooking);
        timeslotService.save(timeSlotModel);

        user.getBookingSet().add(newBooking);
        userService.save(user);
        return new Exception("00");
    }

    public void updateBooking(BookingModel updatedBooking) {
        UserModel user = userService.findUserByEmail();

        TimeSlotModel timeSlotModel = timeslotService.findById(updatedBooking.getDummyTimeSlot());
        timeslotService.save(timeSlotModel);

        ActivityModel activityModel = activityService.findById(updatedBooking.getDummy());

        updatedBooking.setUsers(user);
        updatedBooking.setActivity(activityModel);
        updatedBooking.setTimeSlot(timeSlotModel);
        save(updatedBooking);

        updatedBooking.setTimeSlot(timeSlotModel);
        timeSlotModel.getBookings().add(updatedBooking);
        timeslotService.save(timeSlotModel);

        timeSlotModel.getActivityModelSet().add(activityModel);
        timeSlotModel.getBookings().add(updatedBooking);
        timeslotService.save(timeSlotModel);

        user.getBookingSet().add(updatedBooking);
        userService.save(user);
    }
}
