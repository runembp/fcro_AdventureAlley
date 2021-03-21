package com.adventurealley.aafcro.authorization;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthGroupRepository extends JpaRepository<AuthGroupModel, Long>
{
    List<AuthGroupModel> findByUserEmail(String userEmail);
}
