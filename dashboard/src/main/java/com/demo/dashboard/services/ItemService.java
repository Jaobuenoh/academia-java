package com.demo.dashboard.services;

import com.demo.dashboard.exception.ItemNotFoundException;
import com.demo.dashboard.model.ItemEstoque;
import com.demo.dashboard.repository.ItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemEstoqueRepository itemEstoqueRepository;

    public Iterable<ItemEstoque> getAll(){
        return itemEstoqueRepository.findAll();
    }

    public Optional<ItemEstoque> findId(Long id){
        return itemEstoqueRepository.findById(id);
    }

    public ItemEstoque save(ItemEstoque itemEstoque) {

        return itemEstoqueRepository.save(itemEstoque);
    }

    public void delete(ItemEstoque itemEstoque){
        itemEstoqueRepository.delete(itemEstoque);
    }

    public ItemEstoque findItemOrThrow(Long id) {
        return itemEstoqueRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }


}
