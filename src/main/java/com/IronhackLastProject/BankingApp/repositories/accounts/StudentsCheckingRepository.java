package com.IronhackLastProject.BankingApp.repositories.accounts;

import com.IronhackLastProject.BankingApp.entities.accounts.StudentsChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsCheckingRepository extends JpaRepository<StudentsChecking, Long> {
}
