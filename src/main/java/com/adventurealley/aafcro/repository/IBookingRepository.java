package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<BookingModel, Long>
{
}
