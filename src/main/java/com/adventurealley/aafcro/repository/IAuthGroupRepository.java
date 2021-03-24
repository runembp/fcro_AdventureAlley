package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.AuthGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthGroupRepository extends JpaRepository<AuthGroupModel, Long>
{
    List<AuthGroupModel> findByUserEmail(String userEmail);
}
