package com.IronhackLastProject.BankingApp.services.accounts;

import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.DTOs.AccountDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.*;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.repositories.accounts.*;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
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
    @Autowired
    AccountRepository accountRepository;

    public Account createChecking(AccountDTO checkingDTO){

        Money balance = new Money(new BigDecimal(checkingDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(checkingDTO.getPenaltyFee()));
        AccountHolder primaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));

        AccountHolder secondaryOwner = null;
        if(checkingDTO.getSecondaryOwner() != null && accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).isPresent()){
            secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).get();
        }
        Money minimumBalance = null;
        if(checkingDTO.getMinimumBalance() == null){
            minimumBalance = new Money(new BigDecimal(250));
        }else{
            minimumBalance = new Money(new BigDecimal(checkingDTO.getMinimumBalance()));
        }

        if(Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() < 24){
            return studentsCheckingRepository.save(new StudentsChecking(balance, penaltyFee, primaryOwner, secondaryOwner));

        }
        Checking checking = new Checking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return checkingRepository.save(checking);
    }

    public Savings createSavings(AccountDTO savingsDTO) throws Exception {

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


        StudentsChecking studentsChecking = new StudentsChecking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return studentsCheckingRepository.save(studentsChecking);
    }


    public Optional<List<Account>> findByPrimaryOwnerOrSecondaryOwner(AccountHolder owner) {
        return accountRepository.findByPrimaryOwnerOrSecondaryOwner(owner, owner);
    }
}
