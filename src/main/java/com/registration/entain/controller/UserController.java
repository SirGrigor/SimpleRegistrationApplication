package com.registration.entain.controller;

import com.registration.entain.dto.UserDTO;
import com.registration.entain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDto) {
        String getCurrentLoggedUserName = userService.getCurrentLoggedInUser();
        Long userId = userService.findByEmail(getCurrentLoggedUserName).getId();
        userService.updateUser(userId, userDto);
        return "redirect:/index";
    }

}
