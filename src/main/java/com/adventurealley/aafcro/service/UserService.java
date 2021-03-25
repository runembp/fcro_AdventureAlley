package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    IUserRepository userRepository;

    public UserModel getUserByEmail(String userEmail)
    {
        return userRepository.findUserModelByEmail(userEmail);
    }

    public List<UserModel> findAll()
    {
        return userRepository.findAll();
    }

    public UserModel save(UserModel userModel)
    {
        return userRepository.save(userModel);
    }

    public UserModel findUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }
}
