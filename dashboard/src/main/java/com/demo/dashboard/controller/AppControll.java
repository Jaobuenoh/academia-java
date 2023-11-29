package com.demo.dashboard.controller;


import com.demo.dashboard.model.ItemEstoque;
import com.demo.dashboard.services.ItemService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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


    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("itemService", itemService.getAll());
        return mv;
    }


    @GetMapping("/registro")
    public ModelAndView addItens() {
        ModelAndView mv = new ModelAndView("registro");
        mv.addObject("itemEstoque", new ItemEstoque());
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

        return "redirect:/list";
    }

    @GetMapping("/list/{id}")
    public String findItem(@PathVariable("id") Long id) {

        ItemEstoque itemEstoque = itemService.findItemOrThrow(id);

        return "/list";

    }


    @GetMapping("/error")
    public ModelAndView error () {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("error");
        return mv;
    }
}

