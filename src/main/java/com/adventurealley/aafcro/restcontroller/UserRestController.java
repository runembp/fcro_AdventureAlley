package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import com.adventurealley.aafcro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController
{
    @Autowired
    UserService userService;

    @Autowired
    IUserRepository userRepository;

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
    UserModel postUser(@RequestBody UserModel userModel)
    {
        String salt = BCrypt.gensalt(9);
        String hashedPassword = BCrypt.hashpw(userModel.getPassword(),salt);

        userModel.setPassword(hashedPassword);
        return userService.save(userModel);
    }

    @GetMapping("/getCurrentUserInfo")
    UserModel getCurrentUserInfo()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findUserByEmail(authentication.getName());
    }
}
