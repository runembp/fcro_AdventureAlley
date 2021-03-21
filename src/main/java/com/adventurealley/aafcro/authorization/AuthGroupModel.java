package com.adventurealley.aafcro.authorization;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_USER_GROUP")
public class AuthGroupModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTH_USER_GROUP_ID")
    private Long id;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "AUTH_GROUP")
    private String authGroup;

    public AuthGroupModel()
    {
    }

    public AuthGroupModel(String userEmail, String authGroup)
    {
        this.userEmail = userEmail;
        this.authGroup = authGroup;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getAuthGroup()
    {
        return authGroup;
    }

    public void setAuthGroup(String authGroup)
    {
        this.authGroup = authGroup;
    }
}
