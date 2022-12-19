package com.IronhackLastProject.BankingApp.entities.DTOs;


public class TransferDTO {
    private String amount;
    private Long sendingMoneyId;
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
}
