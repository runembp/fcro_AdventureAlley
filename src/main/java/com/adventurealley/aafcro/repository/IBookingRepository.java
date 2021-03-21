package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface IBookingRepository extends JpaRepository<BookingModel, Long>
{

}
