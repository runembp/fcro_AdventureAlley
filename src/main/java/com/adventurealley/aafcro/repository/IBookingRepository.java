package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IBookingRepository extends JpaRepository<BookingModel, Long>
{
    @Query("select b from BookingModel b join UserModel u on b.users.userID = u.userID where u.email = ?1")
    List<BookingModel> getBookingsToUser(String email);

    @Query(value = "SELECT TITLE, TIME_SLOT_ID, BOOKING_DATE FROM BOOKINGS b \n" +
            "INNER JOIN ACTIVITIES a on b.ACTIVITY_ID = a.ACTIVITY_ID \n" +
            "INNER JOIN USERS u on b.USER_ID = u.USER_ID\n" +
            "WHERE u.EMAIL = ?1",nativeQuery = true)
    List<String> getBookingsForUser(String email);





}
