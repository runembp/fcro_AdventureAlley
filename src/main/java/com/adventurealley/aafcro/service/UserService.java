package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.AuthGroupModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    IUserRepository userRepository;

    @Autowired
    AuthGroupService authGroupService;

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

    public UserModel findUserByEmail()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findUserByEmail(authentication.getName());
    }

    public void postUser(UserModel userModel) {
        String salt = BCrypt.gensalt(9);
        String hashedPassword = BCrypt.hashpw(userModel.getPassword(),salt);

        userModel.setPassword(hashedPassword);

        authGroupService.save(new AuthGroupModel(userModel.getEmail(), "USER"));
        userRepository.save(userModel);
    }
}
