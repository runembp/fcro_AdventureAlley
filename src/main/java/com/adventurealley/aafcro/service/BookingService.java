package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.ActivityBookingDTO;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService
{
    @Autowired
    IBookingRepository bookingRepository;

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

    public List<String> getBookingsForUserCalendar(String userMail)
    {
        return bookingRepository.getBookingsForUser(userMail);
    }

    public void deleteById(Long bookingId)
    {
        bookingRepository.deleteById(bookingId);
    }

    public List<ActivityBookingDTO> findAllBookingsForAllUsers()
    {
        return bookingRepository.findActivityBookings();
//        return bookingRepository.findAllBookingsForAllUsers();
    }
}
