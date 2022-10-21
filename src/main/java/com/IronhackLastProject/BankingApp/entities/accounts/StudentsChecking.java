package com.IronhackLastProject.BankingApp.entities.accounts;

import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.enums.Status;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class StudentsChecking extends Account {

    public StudentsChecking(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
    }

    public StudentsChecking() {
    }
}
