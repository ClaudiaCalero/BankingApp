package com.IronhackLastProject.BankingApp.repositories.accounts;

import com.IronhackLastProject.BankingApp.entities.accounts.StudentsChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsCheckingRepository extends JpaRepository<StudentsChecking, Long> {
    //List<StudentsChecking> findAll(); //no hace falta
}
