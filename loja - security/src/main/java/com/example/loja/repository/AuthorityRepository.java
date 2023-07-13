package com.example.loja.repository;

import com.example.loja.model.Account;
import com.example.loja.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {


}
