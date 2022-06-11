package com.registration.entain.controller;

import com.registration.entain.domain.User;
import com.registration.entain.dto.UserDTO;
import com.registration.entain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private UserService userService;

    private Validator validator;

    @ModelAttribute("user")
    public UserDTO userRegistrationDto() {
        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDto, BindingResult result){

        if (validator.checkEmailExists(userDto.getEmail())){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (!validator.checkEmail(userDto.getEmail(), userDto.getConfirmEmail())){
            result.rejectValue("confirmEmail", null, "Emails doest not match");
        }

        if (!validator.checkPassword(userDto.getPassword(), userDto.getConfirmPassword())){
            result.rejectValue("confirmPassword", null, "Passwords doest not match");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }

}
