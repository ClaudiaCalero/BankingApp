package com.IronhackLastProject.BankingApp.services.users.interfaces;

import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.entities.users.User;

public interface UserServiceInterface {
    Admin createAdmin(Admin admin);

    AccountHolder createAccountHolder(AccountHolder accountHolder);

    ThirdParty createThirdParty(ThirdParty thirdParty);


}
