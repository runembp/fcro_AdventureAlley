package com.adventurealley.aafcro.repository;

import antlr.CodeGenerator;
import com.adventurealley.aafcro.model.ActivityModel;
import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.TimeSlotModel;
import com.adventurealley.aafcro.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface IUserRepository extends JpaRepository<UserModel, Long>
{

    //UserModel findUserModelByEmail(String email);

    @Query("select u from UserModel u where u.email = ?1")
    public UserModel findUserByEmail(String email);

}
