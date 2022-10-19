package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.repositories.users.AdminRepository;
import com.IronhackLastProject.BankingApp.services.users.interfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminService  implements AdminServiceInterface {

    @Autowired
    AdminRepository adminRepository;



}
