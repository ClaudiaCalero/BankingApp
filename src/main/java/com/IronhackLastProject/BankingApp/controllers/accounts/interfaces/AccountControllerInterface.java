package com.IronhackLastProject.BankingApp.controllers.accounts.interfaces;

import com.IronhackLastProject.BankingApp.entities.accounts.Account;

import java.util.List;

public interface AccountControllerInterface {
    Account getAccountById(Long id);
    List<Account> getAllAccounts();
}
