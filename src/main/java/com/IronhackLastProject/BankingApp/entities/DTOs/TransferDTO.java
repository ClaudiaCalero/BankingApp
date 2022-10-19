package com.IronhackLastProject.BankingApp.entities.DTOs;

import com.IronhackLastProject.BankingApp.embeddable.Money;

public class TransferDTO {

    private String amount;
    private Long sendingMoneyId;//idAccountHolder
    private Long receivingMoneyId;

    public TransferDTO(String amount, Long sendingMoneyId, Long receivingMoneyId) {
        this.amount = amount;
        this.sendingMoneyId = sendingMoneyId;
        this.receivingMoneyId = receivingMoneyId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getSendingMoneyId() {
        return sendingMoneyId;
    }

    public void setSendingMoneyId(Long sendingMoneyId) {
        this.sendingMoneyId = sendingMoneyId;
    }

    public Long getReceivingMoneyId() {
        return receivingMoneyId;
    }

    public void setReceivingMoneyId(Long receivingMoneyId) {
        this.receivingMoneyId = receivingMoneyId;
    }

    /* nombre account holder
    id account holder que quiere realizar transfe
    id donde el account holder quiere hacer

    dinero que quiere enviarle*/
}
