package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.repositories.users.UserRepository;
import com.IronhackLastProject.BankingApp.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!userRepository.findByUsername(username).isPresent()) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new CustomUserDetails(userRepository.findByUsername(username).get());
    }
}
