package com.IronhackLastProject.BankingApp.controllers.users;

import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.services.users.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserController {
    @Autowired
    UserServiceInterface userServiceInterface;

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)

    public Admin createAdmin(@RequestBody Admin admin){
        return userServiceInterface.createAdmin(admin);

    }

    @PostMapping("/accountHolder")
    @ResponseStatus(HttpStatus.CREATED)

    public AccountHolder createAccountHolders(@RequestBody AccountHolder accountHolder){
        return userServiceInterface.createAccountHolder(accountHolder);

    }


    @PostMapping("/thirdParty")
    @ResponseStatus(HttpStatus.CREATED)

    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty){
        return userServiceInterface.createThirdParty(thirdParty);

    }
}
