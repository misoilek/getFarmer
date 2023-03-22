package com.example.GetFarmer.services.serviceImpl;

import com.example.GetFarmer.domain.User;
import com.example.GetFarmer.repository.UserRepository;
import com.example.GetFarmer.services.serviceIf.UserServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceIf {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("User with id: " + id +" does not exist")
        );
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
