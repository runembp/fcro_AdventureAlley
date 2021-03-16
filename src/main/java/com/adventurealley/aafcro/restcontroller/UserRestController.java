package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController
{
    @Autowired
    IUserRepository userRepository;

    @GetMapping(("/getAllUsers"))
    List<UserModel> getAllUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping(value = "/postUser", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    UserModel postUser(@RequestBody UserModel userModel)
    {
        return userRepository.save(userModel);
    }
}
