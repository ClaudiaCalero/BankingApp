package com.IronhackLastProject.BankingApp.controllers.users;

import com.IronhackLastProject.BankingApp.controllers.users.interfaces.AccountHolderControllerInterface;
import com.IronhackLastProject.BankingApp.entities.DTOs.TransferAnswerDTO;
import com.IronhackLastProject.BankingApp.entities.DTOs.TransferDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.Account;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.entities.users.User;
import com.IronhackLastProject.BankingApp.enums.Status;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountHolderController  {

    @Autowired
    AccountHolderService accountHolderService;

    @PatchMapping("/transfer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TransferAnswerDTO transferBetweenAccounts(@RequestBody TransferDTO transferDTO){
        return accountHolderService.transferFromOneAccountToAnother(transferDTO);
    }
    @PutMapping("/changeStatus")
    public Account changeStatus(@RequestParam Status status, @RequestParam Long id){
        return accountHolderService.changeAccountStatus(status, id);
    }
    @DeleteMapping("/deleteAccount")
    public void deleteAccount(@PathVariable Long id){
        accountHolderService.deleteAccount(id);
    }
}
