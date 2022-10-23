package com.IronhackLastProject.BankingApp.controllers.accounts;

import com.IronhackLastProject.BankingApp.controllers.accounts.interfaces.CheckingControllerInterface;
import com.IronhackLastProject.BankingApp.entities.accounts.Checking;
import com.IronhackLastProject.BankingApp.services.accounts.CheckingService;
import com.IronhackLastProject.BankingApp.services.accounts.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingController implements CheckingControllerInterface {

   /* @Autowired
    CheckingService checkingService;


    @PostMapping("/admin/checkingAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking addChecking(Checking checking) {
        return checkingService.addChecking(checking);
    }*/



}
