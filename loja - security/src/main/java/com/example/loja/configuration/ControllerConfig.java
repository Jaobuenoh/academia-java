package com.example.loja.configuration;



import com.example.loja.model.Account;
import com.example.loja.model.ItemEstoque;

import com.example.loja.services.AccountService;
import com.example.loja.services.ServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ControllerConfig {

     @Autowired
     private ServiceController serviceController;

     @Autowired
     private AccountService accountService;


    @GetMapping("/c_soon")
    public ModelAndView cSoon(){
        ModelAndView mv = new ModelAndView("c_soon");
        return mv;
    }

     @GetMapping("/home")
      public ModelAndView home(){
         ModelAndView mv = new ModelAndView("home");
         return mv;
         }

     // Register foi substituido de String para ModelAndView para retonar um objeto
     // Tal alteração se deve, pois se não for feita o mesmo gera uma exceção já que é possivel que seja algo nulo
     // Sendo assim é mais viavel colocar um ModelAndView, assim colocando um ItemEstoque() possibilitando um contrutor vazio
    // Att - register foi movido para uma classe especifica.

    @GetMapping("/additens")
    public ModelAndView additens() {
        ModelAndView mv = new ModelAndView("additens");
        mv.addObject("itemEstoque", new ItemEstoque());
        return mv;
    }

//If you can read, you already now what this /additens do...
    @PostMapping("/additens")
    public String register (ItemEstoque itemEstoque, Principal principal) {

        // Esse if verifica se o ID já existe, coleta o mesmo no banco,
        // coloca ele no HTML que já esta mapeado com o thymeleaf, alias, não só ele, seguindo <tr> o mesmo puxa todos os atributos da tabela -
        // lembrado que o ID esta com type hidden para não aparecer - puxando todos os elementos o mesmo apenas substitui o que for desejado,
        // depois armazena novamente com as modificações desejadas.
        // OBS: Caso seja possível; lembrar de trocar o ".orElseThrow" por "Optional" já que o mesmo aceita nulo també, deixando o código mais "bonito"
        if(itemEstoque.getId_item_estoque() !=null) {
            ItemEstoque itemEstoqueid = serviceController.findId(itemEstoque.getId_item_estoque()).orElseThrow(() -> new IllegalArgumentException(" Item: " + itemEstoque.getId_item_estoque() + "Não localizado"));
            serviceController.save(itemEstoque);
        }else {
         // Básicamente coletar o usuário e atrelar ao item que ele adicionou
            String logged = "mistério";

            if (principal != null){
                logged = principal.getName();
            }

            Optional<Account> optionalAccount = accountService.findOneByEmail(logged);
            if (optionalAccount.isPresent()) {
                itemEstoque.setAccount(optionalAccount.get());

                serviceController.save(itemEstoque);
            }
        }
        return"redirect:/list";
    }
//This is the list method, obviously...
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("serviceController", serviceController.getAll());
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id){
        ItemEstoque itemEstoque = serviceController
                .findId(id)
                .orElseThrow(() -> new IllegalArgumentException("Item: " + serviceController.findId(id) + "not found"));

        serviceController.delete(itemEstoque);
        return"redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("additens");

     ItemEstoque itemEstoqueid = serviceController.findId(id).orElseThrow(() -> new IllegalArgumentException("ToDo Item: " + id + "not found"));
     mv.addObject("itemEstoque", itemEstoqueid);
     return mv;

    }

}
