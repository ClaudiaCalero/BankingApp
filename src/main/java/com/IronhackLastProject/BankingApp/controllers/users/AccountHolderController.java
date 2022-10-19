package com.IronhackLastProject.BankingApp.controllers.users;

import com.IronhackLastProject.BankingApp.controllers.users.interfaces.AccountHolderControllerInterface;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderService accountHolderService;


    @PostMapping("/accountHolder")
    @ResponseStatus(HttpStatus.CREATED)

    public AccountHolder createAccountHolders(@RequestBody AccountHolder accountHolder){
        return accountHolderService.createAccountHolder(accountHolder);

    }
}
