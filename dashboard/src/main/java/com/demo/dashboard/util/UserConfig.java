package com.demo.dashboard.util;


import com.demo.dashboard.model.Account;
import com.demo.dashboard.model.Authority;
import com.demo.dashboard.model.UserRole;
import com.demo.dashboard.repository.AuthorityRepository;
import com.demo.dashboard.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;
@Component
public class UserConfig implements CommandLineRunner {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run (String... args) throws Exception {
        Iterable<Account> accounts = accountService.getAll();


        UserRole user = new Authority();
        user.setName("ROLE_USER");
        authorityRepository.save(user);

        Authority admin = new Authority();
        admin.setName("ROLE_ADMIN");
        authorityRepository.save(admin);

        /////////////

        Account account1 = new Account();
        Account account2 = new Account();

        account1.setFistName("user");
        account1.setLastName("user");
        account1.setEmail("user.user@domain.com");
        account1.setPassword("user");
        account1.setId(1L);

        Set<Authority> authorities_1 = new HashSet<>();
        authorityRepository.findById("ROLE_USER").ifPresent(authorities_1::add);
        account1.setAuthorities(authorities_1);

        /////////////

        account2.setFistName("admin");
        account2.setLastName("admin");
        account2.setEmail("admin.admin@domain.com");
        account2.setPassword("admin");
        account2.setId(2L);

        Set<Authority> authorities_2 = new HashSet<>();
        authorityRepository.findById("ROLE_USER").ifPresent(authorities_2::add);
        authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities_2::add);
        account2.setAuthorities(authorities_2);

        accountService.save(account1);
        accountService.save(account2);


    }
}
