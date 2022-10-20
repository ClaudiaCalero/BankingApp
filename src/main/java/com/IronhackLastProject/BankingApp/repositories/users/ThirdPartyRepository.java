package com.IronhackLastProject.BankingApp.repositories.users;

import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {

}
