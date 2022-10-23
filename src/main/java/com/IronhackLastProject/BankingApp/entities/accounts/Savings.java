package com.IronhackLastProject.BankingApp.entities.accounts;

import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Savings extends Account {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="currency", column = @Column(name="minimumCurrency")),
            @AttributeOverride(name="amount", column = @Column(name="amountCurrency"))
    })
    private Money minimumBalance = new Money(BigDecimal.valueOf(1000));
    private BigDecimal interestedRate = BigDecimal.valueOf(0.0025);


    public Savings() {
    }

    public Savings(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money minimumBalance, BigDecimal interestedRate) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
        this.minimumBalance = minimumBalance;
        this.interestedRate = interestedRate;
    }

    public Savings(Money minimumBalance, BigDecimal interestedRate) {
        this.minimumBalance = minimumBalance;
        this.interestedRate = interestedRate;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(BigDecimal interestedRate) {
        this.interestedRate = interestedRate;
    }
}
