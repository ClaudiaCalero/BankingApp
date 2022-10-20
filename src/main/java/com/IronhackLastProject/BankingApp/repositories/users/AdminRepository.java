package com.IronhackLastProject.BankingApp.repositories.users;

import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<AccountHolder, Long> {
    Optional<Object> findByName(String name);

}
