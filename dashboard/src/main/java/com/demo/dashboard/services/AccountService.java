package com.demo.dashboard.services;


import com.demo.dashboard.model.Account;
import com.demo.dashboard.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account save (Account account) {

        account.setPassword(passwordEncoder.encode(account.getPassword()));

        return accountRepository.save(account);
    }

    public Iterable<Account> getAll(){
        return accountRepository.findAll();
    }

    public Optional<Account> findOneByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
