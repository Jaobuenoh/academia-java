package com.demo.dashboard.controller;


import com.demo.dashboard.model.ItemEstoque;
import com.demo.dashboard.model.TipoItemEstoque;
import com.demo.dashboard.services.ItemService;

import com.demo.dashboard.services.TipoService;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppControll {

    private final ItemService itemService;
    private final TipoService tipoService;


    public AppControll(ItemService itemService, TipoService tipoService) {
        this.itemService = itemService;
        this.tipoService = tipoService;
    }


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
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


    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("itemService", itemService.getAll());
        return mv;
    }


    @Transactional
    @GetMapping("/registro")
    public ModelAndView registro() {
        ModelAndView mv = new ModelAndView("registro");
        mv.addObject("itemEstoque", new ItemEstoque());
        mv.addObject("tipoItemEstoque", new TipoItemEstoque());
        return mv;
    }

    @PostMapping("/register")
    public String register(ItemEstoque itemEstoque) {

        itemService.save(itemEstoque);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {


        ItemEstoque itemEstoque = itemService.findItemOrThrow(id);
        itemService.delete(itemEstoque);

        return "redirect:/list";
    }

    @GetMapping("/list/{id}")
    public String findItem(@PathVariable("id") Long id) {

        ItemEstoque itemEstoque = itemService.findItemOrThrow(id);

        return "/list";

    }

    @GetMapping("/edit/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("edit");

        ItemEstoque itemEstoqueid = itemService.findItemOrThrow(id);
        mv.addObject("itemEstoque", itemEstoqueid);
        return mv;
    }


    @GetMapping("/error")
    public ModelAndView error () {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("error");
        return mv;
    }

    @GetMapping("/addType")
    public ModelAndView addType(){
        ModelAndView mv = new ModelAndView("addType");
        mv.addObject("tipoItemEstoque", new TipoItemEstoque());

        return mv;
    }

    @PostMapping("/addType")
    public String typeItem(TipoItemEstoque tipoItemEstoque){
        tipoService.save(tipoItemEstoque);

        return "redirect:/registro";
    }
}

