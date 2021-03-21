package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long>
{
    UserModel findByEmail(String userEmail);
}
