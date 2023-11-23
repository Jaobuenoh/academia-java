package com.demo.dashboard.repository;

import com.demo.dashboard.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEstoqueRepository  extends JpaRepository <ItemEstoque, Long> {
}
