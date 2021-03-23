package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController
{
    @Autowired
    UserService userService;

    @GetMapping(("/getAllUsers"))
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    UserModel postUser(@RequestBody UserModel userModel)
    {
        return userService.save(userModel);
    }
}
