package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IActivityRepository;
import com.adventurealley.aafcro.repository.IBookingRepository;
import com.adventurealley.aafcro.repository.ITimeSlotRepository;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingRestController
{
    @Autowired
    IBookingRepository bookingRepository;

    @Autowired
    IActivityRepository activityRepository;

    @Autowired
    ITimeSlotRepository timeSlotRepository;

    @GetMapping("/findAllBookings")
    public List<BookingModel> findAllBookings()
    {
        return bookingRepository.findAll();
    }

    @Autowired
    IUserRepository userRepository;

    @PostMapping("/postBooking")
    @ResponseStatus(HttpStatus.CREATED)
    BookingModel postBooking(@RequestBody BookingModel booking)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userRepository.findUserByEmail(authentication.getName());

        BookingModel newBooking = bookingRepository.save(booking);
        bookingRepository.save(newBooking);

        TimeSlotModel timeSlotModel = timeSlotRepository.findById(booking.getDummyTimeSlot()).get();
        timeSlotRepository.save(timeSlotModel);

        ActivityModel activityModel = activityRepository.findById(booking.getDummy()).get();
        activityModel.getTimeslot().add(timeSlotModel);
        activityModel.getBookingsSet().add(newBooking);
        activityRepository.save(activityModel);

        newBooking.setUsers(user);
        newBooking.setActivity(activityModel);
        newBooking.setTimeSlot(timeSlotModel);
        bookingRepository.save(newBooking);

        timeSlotModel.getActivityModelSet().add(activityModel);
        timeSlotModel.getBookings().add(newBooking);
        timeSlotRepository.save(timeSlotModel);

        user.getBookingSet().add(newBooking);
        userRepository.save(user);

        return bookingRepository.save(newBooking);
    }

    @GetMapping("/bookingsForCurrentUser")
    public List<BookingModel> bookingsForUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookingRepository.getBookingsToUser(authentication.getName());
    }

    @GetMapping("/getBookingsForCurrentUserCalendar")
    public List<String> getBookingsForUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookingRepository.getBookingsForUser(authentication.getName());
    }

    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteBooking/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId)
    {
        try{
            bookingRepository.deleteById(bookingId);
        }catch (EmptyResultDataAccessException e)
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
