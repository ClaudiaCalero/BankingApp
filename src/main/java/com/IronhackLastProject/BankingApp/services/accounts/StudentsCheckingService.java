package com.IronhackLastProject.BankingApp.services.accounts;

import com.IronhackLastProject.BankingApp.entities.accounts.StudentsChecking;
import com.IronhackLastProject.BankingApp.repositories.accounts.StudentsCheckingRepository;
import com.IronhackLastProject.BankingApp.services.accounts.interfaces.StudentsChekingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsCheckingService implements StudentsChekingServiceInterface {
    @Autowired
    StudentsCheckingRepository studentsCheckingRepository;

    public List<StudentsChecking> getAllStudentsCheckings() {
        return studentsCheckingRepository.findAll();
    }
}
