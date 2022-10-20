package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.entities.users.User;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AdminRepository;
import com.IronhackLastProject.BankingApp.repositories.users.ThirdPartyRepository;
import com.IronhackLastProject.BankingApp.repositories.users.UserRepository;
import com.IronhackLastProject.BankingApp.services.users.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UserService implements UserServiceInterface {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;


    public Admin createAdmin(Admin admin) {
        if()
    }
    public AccountHolder createAccountHolder(AccountHolder accountHolder){
    }

    public ThirdParty createThirdParty(ThirdParty thirdParty) {
    }

}
