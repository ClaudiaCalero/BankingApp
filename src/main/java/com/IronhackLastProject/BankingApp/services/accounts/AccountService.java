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

        AccountHolder primaryOwner = getPrimaryOwner(checkingDTO);
        AccountHolder secondaryOwner = getSecondaryOwner(checkingDTO);

        StudentsChecking studentsCheckingRepository1 = getStudentsChecking(balance, penaltyFee, primaryOwner, secondaryOwner);
        Checking checking = new Checking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return checkingRepository.save(checking);
    }

    private StudentsChecking getStudentsChecking(Money balance, Money penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        if(Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() < 24){
            return studentsCheckingRepository.save(new StudentsChecking(balance, penaltyFee, primaryOwner, secondaryOwner));

        }
        return null;
    }

    public Savings createSavings(AccountDTO savingsDTO) throws Exception {
        Money balance = new Money(new BigDecimal(savingsDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(savingsDTO.getPenaltyFee()));

        AccountHolder primaryOwner = getPrimaryOwner(savingsDTO);
        AccountHolder secondaryOwner = getSecondaryOwner(savingsDTO);

        BigDecimal interestedRate =  new BigDecimal(savingsDTO.getInterestedRate());
        Money minimumBalance = getMinimumBalance(savingsDTO);
        Savings savings = new Savings(balance, penaltyFee, primaryOwner, secondaryOwner, minimumBalance, interestedRate);

        return  savingsRepository.save(savings);
    }

    public CreditCard createCreditCard(AccountDTO creditCardDTO) {
        Money balance = new Money(new BigDecimal(creditCardDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(creditCardDTO.getPenaltyFee()));

        AccountHolder primaryOwner = getPrimaryOwner(creditCardDTO);
        AccountHolder secondaryOwner = getSecondaryOwner(creditCardDTO);

        BigDecimal interestedRate =  new BigDecimal(creditCardDTO.getInterestedRate());
        Money minimumBalance = getMinimumBalance(creditCardDTO);
        CreditCard creditCard = new CreditCard(balance, penaltyFee, primaryOwner, secondaryOwner, minimumBalance, interestedRate);

        return  creditCardRepository.save(creditCard);
    }

    public StudentsChecking createStudentsChecking(AccountDTO studentsCheckingDTO) {
        Money balance = new Money(new BigDecimal(studentsCheckingDTO.getBalance()));
        Money penaltyFee = new Money(new BigDecimal(studentsCheckingDTO.getPenaltyFee()));

        AccountHolder primaryOwner = getPrimaryOwner(studentsCheckingDTO);
        AccountHolder secondaryOwner = getSecondaryOwner(studentsCheckingDTO);

        StudentsChecking studentsChecking = new StudentsChecking(balance, penaltyFee, primaryOwner, secondaryOwner);

        return studentsCheckingRepository.save(studentsChecking);
    }
    private AccountHolder getPrimaryOwner(AccountDTO studentsCheckingDTO) {
        return accountHolderRepository.findById(studentsCheckingDTO.getPrimaryOwner()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    private AccountHolder getSecondaryOwner(AccountDTO studentsCheckingDTO) {
        if(doesNotHaveSecondaryOwner(studentsCheckingDTO) || secondaryOwnerDoesNotExist(studentsCheckingDTO)) {
            return null;
        }

        return getAccountHolder(studentsCheckingDTO);
    }

    private AccountHolder getAccountHolder(AccountDTO studentsCheckingDTO) {
        return accountHolderRepository.findById(studentsCheckingDTO.getSecondaryOwner()).get();
    }

    private boolean secondaryOwnerDoesNotExist(AccountDTO studentsCheckingDTO) {
        return !accountHolderRepository.findById(studentsCheckingDTO.getSecondaryOwner()).isPresent();
    }

    private static boolean doesNotHaveSecondaryOwner(AccountDTO studentsCheckingDTO) {
        return studentsCheckingDTO.getSecondaryOwner() == null;
    }

    private static Money getMinimumBalance(AccountDTO savingsDTO) {
        if(savingsDTO.getMinimumBalance() == null){
            return new Money(new BigDecimal(5000));
        }

        return new Money(new BigDecimal(savingsDTO.getMinimumBalance()));
    }
    public Optional<List<Account>> findByPrimaryOwnerOrSecondaryOwner(AccountHolder owner) {
        return accountRepository.findByPrimaryOwnerOrSecondaryOwner(owner, owner);
    }



}
