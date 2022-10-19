package com.IronhackLastProject.BankingApp.services.accounts;


import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.DTOs.AccountDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.Checking;
import com.IronhackLastProject.BankingApp.entities.accounts.CreditCard;
import com.IronhackLastProject.BankingApp.entities.accounts.Savings;
import com.IronhackLastProject.BankingApp.entities.accounts.StudentsChecking;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.repositories.accounts.CheckingRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.CreditCardRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.SavingsRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.StudentsCheckingRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.IronhackLastProject.BankingApp.repositories.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class AccountService{
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    StudentsCheckingRepository studentsCheckingRepository;



    public Checking createChecking(AccountDTO checkingDTO){

        Money balance = new Money(new BigDecimal(checkingDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(checkingDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        AccountHolder secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        Checking checking = new Checking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return checkingRepository.save(checking);
    }

    public Savings createSavings(AccountDTO savingsDTO){

        Money balance = new Money(new BigDecimal(savingsDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(savingsDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(savingsDTO.getPrimaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        AccountHolder secondaryOwner = accountHolderRepository.findById(savingsDTO.getSecondaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        BigDecimal interestedRate =  new BigDecimal(savingsDTO.getInterestedRate());

        Money minimumBalance = null;
        if(savingsDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(5000));
        }else{
            minimumBalance = new Money(new BigDecimal(savingsDTO.getMinimumBalance()));
        }


        Savings savings = new Savings(balance, penaltyFee, primaryOwner, secondaryOwner, minimumBalance, interestedRate);

        return  savingsRepository.save(savings);
    }


    public CreditCard createCreditCard(AccountDTO creditCardDTO) {


        Money balance = new Money(new BigDecimal(creditCardDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(creditCardDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(creditCardDTO.getPrimaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        AccountHolder secondaryOwner = accountHolderRepository.findById(creditCardDTO.getSecondaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        BigDecimal interestedRate =  new BigDecimal(creditCardDTO.getInterestedRate());

        Money minimumBalance = null;
        if(creditCardDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(5000));
        }else{
            minimumBalance = new Money(new BigDecimal(creditCardDTO.getMinimumBalance()));
        }


        CreditCard creditCard = new CreditCard(balance, penaltyFee, primaryOwner, secondaryOwner, minimumBalance, interestedRate);

        return  creditCardRepository.save(creditCard);
    }

    public StudentsChecking createStudentsChecking(AccountDTO studentsCheckingDTO) {

        Money balance = new Money(new BigDecimal(studentsCheckingDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(studentsCheckingDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(studentsCheckingDTO.getPrimaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        AccountHolder secondaryOwner = accountHolderRepository.findById(studentsCheckingDTO.getSecondaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
        BigDecimal interestedRate =  new BigDecimal(studentsCheckingDTO.getInterestedRate());

        Money minimumBalance = null;
        if(studentsCheckingDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(5000));
        }else{
            minimumBalance = new Money(new BigDecimal(studentsCheckingDTO.getMinimumBalance()));
        }

        StudentsChecking studentsChecking = new StudentsChecking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return studentsCheckingRepository.save(studentsChecking);
    }
}
