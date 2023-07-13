package com.example.loja.services;

import com.example.loja.model.Account;
import com.example.loja.model.ItemEstoque;
import com.example.loja.repository.AccountRepository;
import com.example.loja.repository.ItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceController {

    @Autowired
    private ItemEstoqueRepository itemEstoqueRepository;

    public Iterable<ItemEstoque> getAll(){
        return itemEstoqueRepository.findAll();
    }


    public Optional<ItemEstoque> findId(Long id) {
        return itemEstoqueRepository.findById(id);
    }

    public ItemEstoque save(ItemEstoque itemEstoque) {
        if (itemEstoque.getId_item_estoque() == null){
        }
        return itemEstoqueRepository.save(itemEstoque);
    }

    public void delete(ItemEstoque itemEstoque){
        itemEstoqueRepository.delete(itemEstoque);
    }

    ///////////////////////////////////////

   // @Autowired
    //private AccountRepository accountRepository;


}
