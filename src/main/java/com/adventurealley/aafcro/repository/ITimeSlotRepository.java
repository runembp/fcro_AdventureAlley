package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.TimeSlotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ITimeSlotRepository extends JpaRepository<TimeSlotModel, Long>
{
    @Query("Select t from TimeSlotModel t join BookingModel b on t.timeSlotId = b.timeSlot.timeSlotId where b.bookingID = ?1")
    TimeSlotModel timeslotForBooking(Long bookingId);

}
