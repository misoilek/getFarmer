package com.example.GetFarmer.services.serviceIf;

import com.example.GetFarmer.domain.User;

import java.util.List;

public interface UserServiceIf {
    User getUser(Long id);
    void addUser(User user);
    List<User> getUserList();
}
