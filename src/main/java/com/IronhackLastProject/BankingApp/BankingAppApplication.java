package com.IronhackLastProject.BankingApp;

import com.IronhackLastProject.BankingApp.embeddable.Address;
import com.IronhackLastProject.BankingApp.embeddable.Money;
import com.IronhackLastProject.BankingApp.entities.accounts.Checking;
import com.IronhackLastProject.BankingApp.entities.accounts.CreditCard;
import com.IronhackLastProject.BankingApp.entities.accounts.StudentsChecking;
import com.IronhackLastProject.BankingApp.entities.users.AccountHolder;
import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.repositories.accounts.CheckingRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.CreditCardRepository;
import com.IronhackLastProject.BankingApp.repositories.accounts.StudentsCheckingRepository;
import com.IronhackLastProject.BankingApp.repositories.users.*;
import com.IronhackLastProject.BankingApp.entities.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
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
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	ThirdPartyRepository thirdPartyRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Address address = new Address("Calle Pedraforca", "123", "Barcelona");
		LocalDate dateOfBirth = LocalDate.of(1996, 4, 26);

		AccountHolder accountHolder = new AccountHolder("Cl??udia", passwordEncoder.encode("1234"), dateOfBirth, address, "Cl??udia",address);
		AccountHolder accountHolder2 = new AccountHolder("Nuria", passwordEncoder.encode("4567"), dateOfBirth, address, "Nuria",address);
		accountHolderRepository.saveAll(List.of(accountHolder, accountHolder2));
		roleRepository.save(new Role("HOLDER", accountHolder));
		roleRepository.save(new Role("HOLDER", accountHolder2));

		Admin admin = new Admin("Xavi", passwordEncoder.encode("1234"), "Xavi");
		adminRepository.save(admin);
		roleRepository.save(new Role("ADMIN", admin));

		ThirdParty thirdParty = new ThirdParty("Cyltia",passwordEncoder.encode("7890"), "789", "Cyltia");
		thirdPartyRepository.save(thirdParty);
		roleRepository.save(new Role("THIRD", thirdParty));

		Checking checking1 = new Checking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder, null);
		Checking checking2 = new Checking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder2, null);
		checkingRepository.saveAll(List.of(checking1, checking2));

		CreditCard creditCard1 = new CreditCard(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder, null, new Money(new BigDecimal(250)),  new BigDecimal(String.valueOf(0.5)));
		CreditCard creditCard2 = new CreditCard(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder2, null, new Money(new BigDecimal(250)),  new BigDecimal(String.valueOf(0.5)));
		creditCardRepository.saveAll(List.of(creditCard1, creditCard2));

		StudentsChecking studentsChecking1 = new StudentsChecking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder, null);
		StudentsChecking studentsChecking2 = new StudentsChecking(new Money(new BigDecimal(1000)), new Money(new BigDecimal(50)), accountHolder2, null);
		studentsCheckingRepository.saveAll(List.of(studentsChecking1, studentsChecking2));

		System.out.println(accountHolderRepository.save(accountHolder));
	}
}


