package com.hb.springsecurity.service;

import com.hb.springsecurity.entity.Users;

import java.util.List;

public interface UserService {

    public List<Users> findAll();

    public void saveUser(Users user);

}
