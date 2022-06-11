package com.registration.entain.controller;

import com.registration.entain.dto.UserDTO;
import com.registration.entain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class UserController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDTO userRegistrationDto() {
        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "index";
    }

    @PostMapping
    public String updateUser(@ModelAttribute("user") UserDTO userDto) {
        String getCurrentLoggedUserName = userService.getCurrentLoggedInUser();
        Long userId = userService.findByEmail(getCurrentLoggedUserName).getId();
        userService.updateUser(userId, userDto);
        return "redirect:/";
    }

}
