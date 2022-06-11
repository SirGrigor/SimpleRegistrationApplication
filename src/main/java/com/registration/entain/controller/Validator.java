package com.registration.entain.controller;


import com.registration.entain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Validator implements RegistrationValidation {

    @Autowired
    private UserService userService;

    @Override
    public Boolean checkPassword(String password, String confirmedPassword) {
        return password.equals(confirmedPassword);
    }

    @Override
    public Boolean checkEmail(String email, String confirmedEmail) {
        return email.equals(confirmedEmail);

    }

    @Override
    public Boolean checkEmailExists(String email) {
        return userService.existsByEmail(email);
    }
}
