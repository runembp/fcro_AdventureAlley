package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/postUser")
    UserModel postUser(@RequestBody UserModel userModel)
    {
        return userRepository.save(userModel);
    }


}
