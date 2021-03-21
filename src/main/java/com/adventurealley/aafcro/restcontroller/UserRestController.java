package com.adventurealley.aafcro.restcontroller;

import com.adventurealley.aafcro.model.BookingModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import com.adventurealley.aafcro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController
{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    List<UserModel> getAllUsers()
    {
        return userRepository.findAll();
    }

    //@GetMapping("/getUserByEmail")
    /*public UserModel getUserByEmail(String email)
    {
        return userRepository.findUserModelByEmail(email);
    }*/

    @PostMapping(value = "/postUser", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    UserModel postUser(@RequestBody UserModel userModel)
    {
        return userRepository.save(userModel);
    }


    @GetMapping("/bookingsForCurrentUser/{email}")
    public UserModel findAllBookingsForUser(@PathVariable String email)
    {
        return userRepository.findUserByEmail(email);


        //return  bookingRepository.getBookingsByEmail(email);

    }
}
