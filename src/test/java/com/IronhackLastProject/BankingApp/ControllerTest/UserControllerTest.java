package com.IronhackLastProject.BankingApp.ControllerTest;

import com.IronhackLastProject.BankingApp.embeddable.Address;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AdminRepository;
import com.IronhackLastProject.BankingApp.repositories.users.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    UserRepository userRepository;


    @Test
    void findAll() {
    }

    @Test
    void createAdmin() {
        Admin admin = adminRepository.save(new Admin("Claud", "1234", "Claud"));
        Optional<Admin> adminOptional = adminRepository.findById(admin.getId());
        Assertions.assertTrue(adminOptional.isPresent());
        Admin adminFromDb = adminOptional.get();

        assertEquals("Claud", adminFromDb.getId());
    }

    @Test
    void getAccountHolder() {
    }

    @Test
    void createAccountHolders() {
        AccountHolder accountHolder = accountHolderRepository.save(new AccountHolder("Claud", "1234", LocalDate.of(1996, 4, 26), new Address(),"Claud", new Address()));
        Optional<AccountHolder> accountHolderOptional = accountHolderRepository.findById(accountHolder.getId());
        Assertions.assertTrue(accountHolderOptional.isPresent());
        AccountHolder accountHolderFromDb = accountHolderOptional.get();

        assertEquals("Claud", accountHolderFromDb.getId());
    }


    @Test
    void findByUsername() {
        assertTrue(userRepository.findByUsername("").isPresent());
    }
}