package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface IBookingRepository extends JpaRepository<BookingModel, Long>
{
    @Query(value = "SELECT booking FROM BookingModel booking WHERE booking.activity.activity_id = ?1")
    Set<BookingModel> findAllBookingsForActivity(Long id);
}
