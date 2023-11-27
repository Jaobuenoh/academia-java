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


    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("itemService", itemService.getAll());
        return mv;
    }

    // Foi alterado de @Controller para o @Rest,logo os mapeamentos
    // "redirect:/algumaCoisa" não estão sendo redirecionados para a
    // URL, mas sim exibindo o dado na tela como se fosse json ou algo assim.
    // sera necessário verificar como consumir esse arquivo json corretamente para exibir no gráfico
    // estamos chegando a algum lugar eu acho



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

    @GetMapping("/dashboard")
    public String barGrafh (Model model) {
        Map<String, Integer> surveyMap = new LinkedHashMap<>();
        surveyMap.put("Java", 40);
        surveyMap.put(".Net", 25);
        surveyMap.put("Python", 20);
        surveyMap.put("Dev oops", 15);
        model.addAttribute("surveyMap", surveyMap);
        return "barGraph";
    }

    @GetMapping("/error")
    public ModelAndView error () {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("error");
        return mv;
    }
}

