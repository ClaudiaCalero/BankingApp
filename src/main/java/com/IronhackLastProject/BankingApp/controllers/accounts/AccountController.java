package com.IronhackLastProject.BankingApp.controllers.accounts;

import com.IronhackLastProject.BankingApp.entities.DTOs.AccountDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.*;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.services.accounts.AccountService;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("/createChecking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createChecking(@RequestBody AccountDTO checkingDTO) {
        return accountService.createChecking(checkingDTO);
    }

    @PostMapping("/createSavings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createSavings(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AccountDTO savingsDTO) throws Exception {
        return accountService.createSavings(savingsDTO);
    }

    @PostMapping("/createCreditCard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createCreditCard(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AccountDTO creditCardDTO) {
        return accountService.createCreditCard(creditCardDTO);
    }

    @PostMapping("/createStudentsChecking")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentsChecking createStudentsChecking(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AccountDTO studentsCheckingDTO) {
        return accountService.createStudentsChecking(studentsCheckingDTO);
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<Account>> findOwnedAccountsById(@AuthenticationPrincipal UserDetails userDetails,  @PathVariable Long id) {
        AccountHolder owner = accountHolderService.getAccountHolder(id);
        return accountService.findByPrimaryOwnerOrSecondaryOwner(owner);
    }
}
