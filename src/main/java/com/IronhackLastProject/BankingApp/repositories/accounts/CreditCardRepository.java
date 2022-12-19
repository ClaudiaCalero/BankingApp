package com.IronhackLastProject.BankingApp.repositories.accounts;

import com.IronhackLastProject.BankingApp.entities.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
