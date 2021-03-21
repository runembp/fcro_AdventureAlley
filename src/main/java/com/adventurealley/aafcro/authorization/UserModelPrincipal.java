package com.adventurealley.aafcro.authorization;

import com.adventurealley.aafcro.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserModelPrincipal implements UserDetails
{
    private final UserModel user;
    private final List<AuthGroupModel> authGroupModels;

    public UserModelPrincipal(UserModel user, List<AuthGroupModel> authGroupModels)
    {
        this.user = user;
        this.authGroupModels = authGroupModels;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        if(authGroupModels == null)
        {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroupModels.forEach(group -> grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup())));

        return grantedAuthorities;
    }

    @Override
    public String getPassword()
    {
        return user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
