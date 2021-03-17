package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.TimeSlotModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITimeSlotRepository extends JpaRepository<TimeSlotModel, Long> {
}
