package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookingRepository extends JpaRepository<BookingModel, Long>
{
    class ActivityBooking {
        public final String title;
        public final String bookingDate;
        public final String equipment;
        public final String minAge;
        public final String minHeight;
        public final String firstName;
        public final String lastName;

        public ActivityBooking(String title, String bookingDate, String equipment, String minAge, String minHeight, String firstName, String lastName)
        {
            this.title = title;
            this.bookingDate = bookingDate;
            this.equipment = equipment;
            this.minAge = minAge;
            this.minHeight = minHeight;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    @Query("select b from BookingModel b join UserModel u on b.users.userID = u.userID where u.email = ?1")
    List<BookingModel> getBookingsToUser(String email);

    @Query(value = "SELECT TITLE, TIME_SLOT_ID, BOOKING_DATE FROM BOOKINGS b \n" +
            "INNER JOIN ACTIVITIES a on b.ACTIVITY_ID = a.ACTIVITY_ID \n" +
            "INNER JOIN USERS u on b.USER_ID = u.USER_ID\n" +
            "WHERE u.EMAIL = ?1",nativeQuery = true)
    List<String> getBookingsForUser(String email);

    @Query(value = "SELECT TITLE, BOOKING_DATE, TIME_SLOT_ID, EQUIPMENT, MIN_AGE, MIN_HEIGHT, FIRST_NAME, LAST_NAME, HEIGHT FROM BOOKINGS b \n" +
            "INNER JOIN ACTIVITIES a on b.ACTIVITY_ID = a.ACTIVITY_ID\n" +
            "INNER JOIN users u on b.USER_ID = u.USER_ID;", nativeQuery = true)
    List<Object[]> findAllBookingsForAllUsers();
}
