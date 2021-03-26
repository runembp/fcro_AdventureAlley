package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IActivityRepository extends JpaRepository<ActivityModel, Long>
{
    @Query("select a from ActivityModel a join BookingModel b on a.activityId = b.activity.activityId where b.bookingID = ?1")
    ActivityModel getActivityToBooking(Long bookingID);
}
