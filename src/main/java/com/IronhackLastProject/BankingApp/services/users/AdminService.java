package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.entities.users.User;
import com.IronhackLastProject.BankingApp.repositories.users.AdminRepository;
import com.IronhackLastProject.BankingApp.services.users.interfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class AdminService   {


    @Autowired
    AdminRepository adminRepository;

  /*  public Admin createAdmin(Admin admin) {

    }
*/
}
