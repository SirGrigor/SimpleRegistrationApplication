package com.registration.entain.controller;

import com.registration.entain.dto.UserDTO;
import com.registration.entain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public String root(Model model) {
        Long userId = userService.getUserIdByLoggedUser();
        UserDTO userDTO = userService.findById(userId);
        model.addAttribute("user", userDTO);
        return "index";
    }

    @PostMapping
    public String updateUser(@ModelAttribute("user") UserDTO userDto, Model model, BindingResult result) {
        Long userId = userService.getUserIdByLoggedUser();
        UserDTO userDTO = userService.findById(userId);
        model.addAttribute("user", userDTO);

        if (Objects.equals(userDto.getPassword(), "")) {
            result.rejectValue("password", null, "Password cannot be empty");
        }
        if (result.hasErrors()) {
            return "index";
        }
        userService.updateUser(userId, userDto);
        return "redirect:/index?success";
    }


}
