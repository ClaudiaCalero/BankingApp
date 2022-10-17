package com.IronhackLastProject.BankingApp.entities.accounts;

import ch.qos.logback.core.status.Status;
import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primaryOwnerId")
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondaryOwnerId")
    private AccountHolder secondaryOwner; // (optional)

    private LocalDate creationDate;

    private Status status;

    public Account(Long id, Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate, Status status) {
        this.id = id;
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
