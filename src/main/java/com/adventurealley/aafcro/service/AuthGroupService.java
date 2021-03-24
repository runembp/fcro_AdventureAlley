package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.model.AuthGroupModel;
import com.adventurealley.aafcro.repository.IAuthGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthGroupService
{
    @Autowired
    IAuthGroupRepository authGroupRepository;

    public void save(AuthGroupModel user)
    {
        authGroupRepository.save(new AuthGroupModel(user.getUserEmail(), "USER"));
    }
}
