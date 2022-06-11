package com.registration.entain.controller;

import com.registration.entain.dto.UserDTO;
import com.registration.entain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String root(Model model) {
        String getCurrentLoggedUserName = userService.getCurrentLoggedInUser();
        Long userId = userService.findByEmail(getCurrentLoggedUserName).getId();
        UserDTO userDTO = userService.findById(userId);
        model.addAttribute("user", userDTO);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


}
