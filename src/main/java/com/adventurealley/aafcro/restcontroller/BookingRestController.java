package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.service.ActivityService;
import com.adventurealley.aafcro.service.BookingService;
import com.adventurealley.aafcro.service.TimeslotService;
import com.adventurealley.aafcro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class BookingRestController
{
    @Autowired
    BookingService bookingService;

    @Autowired
    ActivityService activityService;

    @Autowired
    TimeslotService timeslotService;

    @Autowired
    UserService userService;

    @GetMapping("/findAllBookings")
    public List<BookingModel> findAllBookings()
    {
        return bookingService.findAll();
    }

    @PostMapping("/postBooking")
    @ResponseStatus(HttpStatus.CREATED)
    Serializable postBooking(@RequestBody BookingModel booking)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userService.findUserByEmail(authentication.getName());

        List<BookingModel> userBookingList = bookingService.getBookingsToUser(authentication.getName());

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

        BookingModel newBooking = bookingService.save(booking);
        bookingService.save(newBooking);

        TimeSlotModel timeSlotModel = timeslotService.findById(booking.getDummyTimeSlot());
        timeslotService.save(timeSlotModel);

        ActivityModel activityModel = activityService.findById(booking.getDummy());
        activityModel.getTimeslot().add(timeSlotModel);
        activityModel.getBookingsSet().add(newBooking);
        activityService.save(activityModel);

        newBooking.setUsers(user);
        newBooking.setActivity(activityModel);
        newBooking.setTimeSlot(timeSlotModel);
        bookingService.save(newBooking);

        timeSlotModel.getActivityModelSet().add(activityModel);
        timeSlotModel.getBookings().add(newBooking);
        timeslotService.save(timeSlotModel);

        user.getBookingSet().add(newBooking);
        userService.save(user);

        return bookingService.save(newBooking);
    }

    @GetMapping("/bookingsForCurrentUser")
    public List<BookingModel> bookingsForUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookingService.getBookingsToUser(authentication.getName());
    }

    @GetMapping("/getBookingsForCurrentUserCalendar")
    public List<String> getBookingsForUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookingService.getBookingsForUserCalendar(authentication.getName());
    }

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteBooking/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId)
    {
        try
        {
            bookingService.deleteById(bookingId);
        }
        catch (EmptyResultDataAccessException e)
        {
            System.out.println("Error..... " + e.getMessage());
        }
    }

    @PutMapping(value = "/updateTimeslotForBooking", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingModel updateBooking(@RequestBody BookingModel updatedBooking)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userRepository.findUserByEmail(authentication.getName());

        TimeSlotModel timeSlotModel = timeSlotRepository.findById(updatedBooking.getDummyTimeSlot()).get();
        timeSlotRepository.save(timeSlotModel);

        ActivityModel activityModel = activityRepository.findById(updatedBooking.getDummy()).get();

        updatedBooking.setUsers(user);
        updatedBooking.setActivity(activityModel);
        updatedBooking.setTimeSlot(timeSlotModel);
        bookingRepository.save(updatedBooking);

        updatedBooking.setTimeSlot(timeSlotModel);
        timeSlotModel.getBookings().add(updatedBooking);
        timeSlotRepository.save(timeSlotModel);

        timeSlotModel.getActivityModelSet().add(activityModel);
        timeSlotModel.getBookings().add(updatedBooking);
        timeSlotRepository.save(timeSlotModel);

        user.getBookingSet().add(updatedBooking);
        userRepository.save(user);

        return bookingRepository.save(updatedBooking);
    }




}
