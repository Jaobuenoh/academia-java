package com.demo.dashboard.services;

import com.demo.dashboard.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;





@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        repository.findOneByEmail(email);

        if (email == null) {
            throw new UsernameNotFoundException("Not found :c");
        }

       return repository.findOneByEmail(email);

    }
}