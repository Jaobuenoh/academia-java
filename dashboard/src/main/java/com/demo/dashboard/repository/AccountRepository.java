package com.demo.dashboard.repository;

import com.demo.dashboard.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {

    UserDetails findOneByEmail(String email);

    Optional<Account> findByEmail(String email);
}

