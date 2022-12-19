package com.IronhackLastProject.BankingApp.controllers.users;

import com.IronhackLastProject.BankingApp.entities.DTOs.TransferAnswerDTO;
import com.IronhackLastProject.BankingApp.entities.DTOs.TransferDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.Account;
import com.IronhackLastProject.BankingApp.enums.Status;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountHolderController  {
    @Autowired
    AccountHolderService accountHolderService;

    @PatchMapping("/transfer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TransferAnswerDTO transferBetweenAccounts(@AuthenticationPrincipal UserDetails userDetails,  @RequestBody TransferDTO transferDTO){
        return accountHolderService.transferFromOneAccountToAnother(transferDTO);
    }

    @PutMapping("/changeStatus")
    public Account changeStatus(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Status status, @RequestParam Long id){
        return accountHolderService.changeAccountStatus(status, id);
    }
    @DeleteMapping("/deleteAccount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long id){
        accountHolderService.deleteAccount(id);
    }
}
