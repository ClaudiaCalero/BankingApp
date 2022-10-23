package com.IronhackLastProject.BankingApp.repositories.users;

import com.IronhackLastProject.BankingApp.entities.DTOs.TransferDTO;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
    void deleteById(Long id);
}
