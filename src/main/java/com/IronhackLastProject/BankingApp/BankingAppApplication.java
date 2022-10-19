package com.IronhackLastProject.BankingApp;

import com.IronhackLastProject.BankingApp.embeddable.Address;
import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.accounts.Checking;
import com.IronhackLastProject.BankingApp.entities.accounts.CreditCard;
import com.IronhackLastProject.BankingApp.entities.accounts.StudentsChecking;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.repositories.accounts.CheckingRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.CreditCardRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.StudentsCheckingRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner {
	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
	CheckingRepository checkingRepository;
	@Autowired
	CreditCardRepository creditCardRepository;

	@Autowired
	StudentsCheckingRepository studentsCheckingRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Calle de la Piruleta", "777", "País de la Gominola");
		LocalDate dateOfBirth = LocalDate.of(1996, 4, 26);

		AccountHolder accountHolder = new AccountHolder(dateOfBirth, address, "Sole", address);
		AccountHolder accountHolder2 = new AccountHolder(dateOfBirth, address, "Claud", address);

		accountHolderRepository.saveAll(List.of(accountHolder, accountHolder2));

		Checking checking1 = new Checking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder, accountHolder);
		Checking checking2 = new Checking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder2, accountHolder2);

		checkingRepository.saveAll(List.of(checking1, checking2));

		CreditCard creditCard1 = new CreditCard(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder, accountHolder, new Money(new BigDecimal(250)), new BigDecimal(String.valueOf(new Money())));
		CreditCard creditCard2 = new CreditCard(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder2, accountHolder2, new Money(new BigDecimal(250)), new BigDecimal(String.valueOf(new Money())));

		creditCardRepository.saveAll(List.of(creditCard1, creditCard2));

		StudentsChecking studentsChecking1 = new StudentsChecking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder, accountHolder);
		StudentsChecking studentsChecking2 = new StudentsChecking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder2, accountHolder2);

		studentsCheckingRepository.saveAll(List.of(studentsChecking1, studentsChecking2));


		System.out.println(accountHolderRepository.save(accountHolder));
	}
}


