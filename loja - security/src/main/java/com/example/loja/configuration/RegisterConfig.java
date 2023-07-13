package com.example.loja.configuration;

import com.example.loja.model.Account;
import com.example.loja.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterConfig {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String getRegister(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Account account){
        accountService.save(account);

        return "redirect:/pagina que você deseja";
    }
}
