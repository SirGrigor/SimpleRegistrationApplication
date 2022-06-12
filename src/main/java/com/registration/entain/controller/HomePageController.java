package com.registration.entain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String root(Model model) {
        return "redirect:/registration";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


}
