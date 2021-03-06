package com.adventurealley.aafcro.service;

import com.adventurealley.aafcro.repository.IAuthGroupRepository;
import com.adventurealley.aafcro.authorization.UserModelPrincipal;
import com.adventurealley.aafcro.model.AuthGroupModel;
import com.adventurealley.aafcro.model.UserModel;
import com.adventurealley.aafcro.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserDetailService implements UserDetailsService
{
    private final IUserRepository userRepository;
    private final IAuthGroupRepository authGroupRepository;

    public AuthUserDetailService(IUserRepository userRepository, IAuthGroupRepository authGroupRepository)
    {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException
    {
        UserModel user = userRepository.findUserModelByEmail(userEmail);
        if(user == null)
        {
            throw new UsernameNotFoundException("Useremail not found: " + userEmail);
        }
        List<AuthGroupModel> authGroups = authGroupRepository.findByUserEmail(userEmail);
        return new UserModelPrincipal(user,authGroups);
    }
}
