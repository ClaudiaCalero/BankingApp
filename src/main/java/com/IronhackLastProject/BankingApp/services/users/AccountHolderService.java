package com.IronhackLastProject.BankingApp.services.users;

import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.DTOs.TransferAnswerDTO;
import com.IronhackLastProject.BankingApp.entities.DTOs.TransferDTO;
import com.IronhackLastProject.BankingApp.entities.accounts.Account;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.enums.Status;
import com.IronhackLastProject.BankingApp.repositories.accounts.AccountRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.IronhackLastProject.BankingApp.services.users.interfaces.AccountHolderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    //metodos para crear accountHolder;
    //metodos para tranferir de una cuenta a la otra;
    //metodo para que un AH vea su balances;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    public TransferAnswerDTO transferFromOneAccountToAnother(TransferDTO transferDTO) {

        if (accountRepository.findById(transferDTO.getReceivingMoneyId()).isPresent() && accountRepository.findById(transferDTO.getSendingMoneyId()).isPresent()) {

            Account sendingAccount = accountRepository.findById(transferDTO.getSendingMoneyId()).get();
            Account receivingAccount = accountRepository.findById(transferDTO.getReceivingMoneyId()).get();
            BigDecimal amount = new BigDecimal(transferDTO.getAmount());

            if (sendingAccount.getBalance().getAmount().compareTo(amount) < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This account do not have enough funds");
            }
            sendingAccount.setBalance(new Money(sendingAccount.getBalance().decreaseAmount(amount)));
            receivingAccount.setBalance(new Money(receivingAccount.getBalance().increaseAmount(amount)));
            accountRepository.saveAll(List.of(sendingAccount, receivingAccount));
            return new TransferAnswerDTO(sendingAccount.getPrimaryOwner().getName(), receivingAccount.getPrimaryOwner().getName(), amount);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one or both of the accounts do not exist");


    }

    public Money toCheckBalance(Long id, Long accountId){

        if(accountHolderRepository.findById(id).isPresent() && accountRepository.findById(accountId).isPresent()) {
            AccountHolder holderId = accountHolderRepository.findById(id).get();
            Account account = accountRepository.findById(accountId).get();
            if (account.getPrimaryOwner().getId().equals(holderId.getId()) || account.getSecondaryOwner().getId().equals(holderId.getId())) {
                return account.getBalance();
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE," ");
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Holder do not exist");
    }

    public Account changeAccountStatus(Status status, Long id){
        Account account = accountRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT));
        account.setStatus(status);
        return accountRepository.save(account);

    }

    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    public AccountHolder getAccountHolder(Long id) {
        return accountHolderRepository.findById(id).get();
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


}
