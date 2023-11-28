package com.demo.dashboard.controller;

import com.demo.dashboard.exception.ItemNotFoundException;
import com.demo.dashboard.model.ItemEstoque;
import com.demo.dashboard.model.TipoItemEstoque;
import com.demo.dashboard.repository.TipoItemEstoqueRepository;
import com.demo.dashboard.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AppControll {

    private final ItemService itemService;

    public AppControll(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("itemService", itemService.getAll());
        return mv;
    }


    @GetMapping("/registro")
    public ModelAndView addItens() {
        ModelAndView mv = new ModelAndView("registro");
        mv.addObject("itemEstoque", new ItemEstoque());
        mv.addObject("tipoItemEstoque", new TipoItemEstoque());
        return mv;
    }

    @PostMapping("/registro")
    public String register(ItemEstoque itemEstoque) {

       itemService.save(itemEstoque);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {


        ItemEstoque itemEstoque = itemService.findItemOrThrow(id);
        itemService.delete(itemEstoque);

        return"redirect:/list";
    }
}

