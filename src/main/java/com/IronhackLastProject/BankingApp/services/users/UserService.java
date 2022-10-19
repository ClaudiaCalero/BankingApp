package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.entities.users.User;
import com.IronhackLastProject.BankingApp.repositories.users.UserRepository;
import com.IronhackLastProject.BankingApp.services.users.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
