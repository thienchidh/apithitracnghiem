package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
