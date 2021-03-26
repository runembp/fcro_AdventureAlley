package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.service.AuthGroupService;
import com.adventurealley.aafcro.service.TimeslotService;
import com.adventurealley.aafcro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController
{
    @Autowired
    UserService userService;

    @Autowired
    TimeslotService timeslotService;

    @Autowired
    AuthGroupService authGroupService;

    @GetMapping("/getAllUsers")
    List<UserModel> getAllUsers()
    {
        return userService.findAll();
    }

    @GetMapping("/getUserByEmail/{userEmail}")
    UserModel getUserByEmail(@PathVariable String userEmail)
    {
        return userService.getUserByEmail(userEmail);
    }

    @PostMapping(value = "/postUser", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    void postUser(@RequestBody UserModel userModel)
    {
        userService.postUser(userModel);
    }

    @GetMapping("/getCurrentUserInfo")
    UserModel getCurrentUserInfo()
    {
        return userService.findUserByEmail();
    }
}
