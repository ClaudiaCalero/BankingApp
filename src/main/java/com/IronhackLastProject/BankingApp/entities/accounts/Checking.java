package com.IronhackLastProject.BankingApp.entities.accounts;

import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="currency", column = @Column(name="minimumCurrency")),
            @AttributeOverride(name="amount", column = @Column(name="amountCurrency"))

    })

    private final Money minimumBalance = new Money(BigDecimal.valueOf(250));

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="currency", column = @Column(name="monthlyCurrency")),
            @AttributeOverride(name="amount", column = @Column(name="monthlyAmount"))

    })
    private final Money monthlyMaintenanceFee = new Money(BigDecimal.valueOf(12));


    public Checking(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
    }

    public Checking() {
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }
}
