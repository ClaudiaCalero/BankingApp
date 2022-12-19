package com.IronhackLastProject.BankingApp.entities.accounts;

import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class CreditCard extends Account {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="currency", column = @Column(name="minimumCurrency")),
            @AttributeOverride(name="amount", column = @Column(name="amountCurrency"))

    })

   private Money creditLimit = new Money(BigDecimal.valueOf(250));
    private BigDecimal interestedRate = BigDecimal.valueOf(0.2);

    public CreditCard(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit, BigDecimal interestedRate) {
        super(balance, penaltyFee, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestedRate = interestedRate;
    }
    public CreditCard() {
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(BigDecimal interestedRate) {
        this.interestedRate = interestedRate;
    }
}
