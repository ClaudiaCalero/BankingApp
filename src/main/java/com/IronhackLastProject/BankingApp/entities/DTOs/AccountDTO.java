package com.IronhackLastProject.BankingApp.entities.DTOs;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AccountDTO {

    @NotEmpty
    private String balance;
    private String penaltyFee;
    @NotNull
    private Long primaryOwner;
    private Long secondaryOwner;

    private String interestedRate;
    private String minimumBalance;

    public AccountDTO(String balance, String penaltyFee, Long primaryOwner, Long secondaryOwner, String interestedRate, String minimumBalance) {
        this.balance = balance;
        this.penaltyFee = penaltyFee;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.interestedRate = interestedRate;
        this.minimumBalance = minimumBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(String penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Long getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Long primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Long getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Long secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(String interestedRate) {
        this.interestedRate = interestedRate;
    }

    public String getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(String minimumBalance) {
        this.minimumBalance = minimumBalance;
    }


}
