package com.IronhackLastProject.BankingApp.controllers.accounts;


import com.IronhackLastProject.BankingApp.entities.DTOs.AccountDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.*;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.services.accounts.AccountService;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Savings createSavings(@RequestBody AccountDTO savingsDTO) throws Exception {
        return accountService.createSavings(savingsDTO);

    }

    @PostMapping("/createCreditCard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createCreditCard(@RequestBody AccountDTO creditCardDTO) {
        return accountService.createCreditCard(creditCardDTO);
    }

    @PostMapping("/createStudentsChecking")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentsChecking createStudentsChecking(@RequestBody AccountDTO studentsCheckingDTO) {
        return accountService.createStudentsChecking(studentsCheckingDTO);
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<Account>> findOwnedAccountsById(@PathVariable Long id) {
        AccountHolder owner = accountHolderService.getAccountHolder(id);
        return accountService.findByPrimaryOwnerOrSecondaryOwner(owner);
    }

}
//crear 4 tipos cuentas, un party, transferencias entre accountholders y partys, account acceder a balance, admin acceder balance a cualuqier cuenta
//y si quiera puede modificarlo