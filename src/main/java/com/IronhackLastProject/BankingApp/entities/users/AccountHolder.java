package com.IronhackLastProject.BankingApp.entities.users;

import com.IronhackLastProject.BankingApp.embeddable.Address;
import com.IronhackLastProject.BankingApp.entities.accounts.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AccountHolder extends User {

    //@NotBlank(message = "This field can not be blank")
    //@NotNull(message = "This field can not be null")
    private LocalDate dateOfBirth;

    //@NotBlank(message = "This field can not be blank")
    //@NotNull(message = "This field can not be null")
    private Address primaryAddress;

    //@NotBlank(message = "This field can not be blank")
    //@NotNull(message = "This field can not be null")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="streetName", column = @Column(name="streetName1")),
            @AttributeOverride(name="streetNum", column = @Column(name="streetNum1")),
            @AttributeOverride(name="city", column = @Column(name="city1"))


    })

    private Address mailingAddress;

    //@NotBlank(message = "This field can not be blank")
   // @NotNull(message = "This field can not be null")
    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> primaryAccountList;

    //@NotNull(message = "This field can not be null")
    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Account> secondaryAccountList;

    //@NotBlank(message = "This field can not be blank")
    //@NotNull(message = "This field can not be null")
    //private Money monthlySpended = new Money(BigDecimal.valueOf(0)); extra points


    public AccountHolder(String username, String password, LocalDate dateOfBirth, Address primaryAddress, String name, Address mailingAddress) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.name = name;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolder() {
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getPrimaryAccountList() {
        return primaryAccountList;
    }

    public void setPrimaryAccountList(List<Account> primaryAccountList) {
        this.primaryAccountList = primaryAccountList;
    }

    public List<Account> getSecondaryAccountList() {
        return secondaryAccountList;
    }

    public void setSecondaryAccountList(List<Account> secondaryAccountList) {
        this.secondaryAccountList = secondaryAccountList;
    }


}
