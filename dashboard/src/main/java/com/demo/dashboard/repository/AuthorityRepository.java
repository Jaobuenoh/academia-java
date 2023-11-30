package com.demo.dashboard.repository;

import com.demo.dashboard.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

}

