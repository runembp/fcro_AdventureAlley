package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActivityRepository extends JpaRepository<ActivityModel, Long>
{
}
