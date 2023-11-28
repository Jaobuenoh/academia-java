package com.example.loja.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginConfig {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @GetMapping("/malandro_sem_script")
    public ModelAndView noScript(){
        ModelAndView mv = new ModelAndView("semscript");
        return mv;
    }

    @GetMapping("/login_error")
    public ModelAndView loginError(){
        ModelAndView mv = new ModelAndView("login_error");
        return mv;
    }
}
