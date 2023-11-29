package com.demo.dashboard.controller;

import com.demo.dashboard.model.ItemEstoque;
import com.demo.dashboard.services.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppRestControll {

    private final ItemService itemService;

    public AppRestControll(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/list")
    @ResponseBody
    public List<ItemEstoque> listaItensJSON() {
        Iterable<ItemEstoque> iterableItens = itemService.getAll();
        List<ItemEstoque> listaItens = new ArrayList<>();

        iterableItens.forEach(listaItens::add);

        return listaItens;
    }
}
