package com.demo.dashboard.controller;


import com.demo.dashboard.dto.TipoItemEstoqueDTO;
import com.demo.dashboard.model.TipoItemEstoque;
import com.demo.dashboard.repository.TipoItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TipoItemEstoqueController {
    @Autowired
    private TipoItemEstoqueRepository repository;

    @GetMapping("/data")
    public List<TipoItemEstoqueDTO> getData(){
        List<TipoItemEstoque> tipoItemEstoques = repository.findAll();

        List<TipoItemEstoqueDTO> tipoItemEstoqueDTOs = tipoItemEstoques.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return tipoItemEstoqueDTOs;
    }

    private TipoItemEstoqueDTO convertToDTO(TipoItemEstoque tipoItemEstoque){
        TipoItemEstoqueDTO dto = new TipoItemEstoqueDTO();
        dto.setId(tipoItemEstoque.getId_tipo_item_estoque());
        dto.setDescricao(tipoItemEstoque.getDescricao_tipo_item_estoque());
        return dto;
    }
}
