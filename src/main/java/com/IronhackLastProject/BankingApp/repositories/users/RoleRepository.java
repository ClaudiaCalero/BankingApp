package com.IronhackLastProject.BankingApp.repositories.users;

import com.IronhackLastProject.BankingApp.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
