package com.registration.entain.controller;

import com.registration.entain.domain.User;
import com.registration.entain.dto.UserDTO;
import com.registration.entain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registration")

public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDTO userRegistrationDto() {
        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")  UserDTO userDto, BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        } else if (result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }

    @PatchMapping
    public String updateUser(@ModelAttribute("user")  UserDTO userDto, BindingResult result){

        if (userService.existsByEmail(userDto.getEmail())) {
            userService.save(userDto);
            return "index";
        } else if (result.hasErrors()) {
            return "index";
        }

        userService.save(userDto);
        return "redirect:/index?success";
    }
}
