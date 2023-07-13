package com.example.loja.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginConfig {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
