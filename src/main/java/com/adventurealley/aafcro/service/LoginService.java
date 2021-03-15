package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{
    @Autowired
    IUserRepository loginRepository;

    public boolean isUserAuthenticated(String email, String password)
    {
        if(loginRepository.findAll().stream().anyMatch(x -> x.getEmail().equals(email) && x.getPassword().equals(password)))
        {
            return true;
        }

        return false;
    }

    public void createNewUser(UserModel user)
    {
        loginRepository.save(user);
    }

    public UserModel getUserByEmail(String email)
    {
        var list = loginRepository.findAll();

        if(list.stream().findFirst().filter(x -> x.getEmail().equals(email)).isPresent())
        {
            return list.stream().findFirst().filter(x -> x.getEmail().equals(email)).get();
        }

        return null;
    }
}
