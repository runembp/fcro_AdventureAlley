package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IBookingRepository extends JpaRepository<BookingModel, Long>
{
    @Query("select b from BookingModel b join UserModel u on b.users.userID = u.userID where u.email = ?1")
    List<BookingModel> getBookingsToUser(String email);
}
