package com.demo.dashboard.services;

import com.demo.dashboard.exception.ItemNotFoundException;
import com.demo.dashboard.model.TipoItemEstoque;
import com.demo.dashboard.repository.TipoItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    private TipoItemEstoqueRepository tipoItemEstoqueRepository;

    @Transactional
    public Iterable<TipoItemEstoque> getAll(){
        return tipoItemEstoqueRepository.findAll();
    }

    public Optional<TipoItemEstoque> findId(Long id){
        return tipoItemEstoqueRepository.findById(id);
    }

    public TipoItemEstoque save(TipoItemEstoque tipoItemEstoque) {

        return tipoItemEstoqueRepository.save(tipoItemEstoque);
    }

    public void delete(TipoItemEstoque tipoItemEstoque){
        tipoItemEstoqueRepository.delete(tipoItemEstoque);
    }

    public TipoItemEstoque findItemOrThrow(Long id) {
        return tipoItemEstoqueRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }
}
