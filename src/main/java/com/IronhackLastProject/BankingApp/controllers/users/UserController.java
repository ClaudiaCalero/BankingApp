package com.IronhackLastProject.BankingApp.controllers.users;

import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.entities.users.User;
import com.IronhackLastProject.BankingApp.repositories.users.UserRepository;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import com.IronhackLastProject.BankingApp.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountHolderService accountHolderService;
    @GetMapping("/users")
    public List<User> findAll(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails.getUsername());
        return userRepository.findAll();
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Admin admin){
        return userService.createAdmin(admin);
    }

    @GetMapping("/accountHolder/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder getAccountHolder(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long id) {
        return accountHolderService.getAccountHolder(id);
    }

    @PostMapping("/accountHolder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolders(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AccountHolder accountHolder){
        return userService.createAccountHolder(accountHolder);
    }

    @PostMapping("/thirdParty")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ThirdParty thirdParty){
        return userService.createThirdParty(thirdParty);
    }
}
