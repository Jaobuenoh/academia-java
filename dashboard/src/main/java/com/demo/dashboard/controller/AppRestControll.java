package com.demo.dashboard.controller;

import com.demo.dashboard.model.ItemEstoque;
import com.demo.dashboard.model.TipoItemEstoque;
import com.demo.dashboard.services.ItemService;
import com.demo.dashboard.services.TipoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppRestControll {

    private final ItemService itemService;
    private final TipoService tipoService;

    public AppRestControll(ItemService itemService, TipoService tipoService) {
        this.itemService = itemService;
        this.tipoService = tipoService;
    }


    @GetMapping("/list")
    @ResponseBody
    public List<ItemEstoque> listaItensJSON() {
        Iterable<ItemEstoque> iterableItens = itemService.getAll();
        List<ItemEstoque> listaItens = new ArrayList<>();

        iterableItens.forEach(listaItens::add);

        return listaItens;
    }

    @GetMapping("/tipo_item")
    @ResponseBody
    public List<TipoItemEstoque> listaTipoJSON() {
        Iterable<TipoItemEstoque> iterableTipo = tipoService.getAll();
        List<TipoItemEstoque> listaTipo = new ArrayList<>();

        iterableTipo.forEach(listaTipo::add);

        return listaTipo;
    }


}
