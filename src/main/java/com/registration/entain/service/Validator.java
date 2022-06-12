package com.registration.entain.service;


import com.registration.entain.service.UserService;
import com.registration.entain.service.ValidatorInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class Validator implements ValidatorInterface {

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
