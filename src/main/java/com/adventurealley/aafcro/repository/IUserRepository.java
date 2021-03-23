package com.adventurealley.aafcro.repository;

import com.adventurealley.aafcro.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<UserModel, Long>
{
    @Query("select u from UserModel u where u.email = ?1")
    UserModel findUserByEmail(String email);

}
