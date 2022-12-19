package com.IronhackLastProject.BankingApp.repositories.accounts;

import com.IronhackLastProject.BankingApp.entities.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
