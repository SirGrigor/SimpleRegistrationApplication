package com.registration.entain.controller;

public interface RegistrationValidation {

    Boolean checkPassword(String password, String confirmedPassword);

    Boolean checkEmail(String email, String confirmedEmail);

    Boolean checkEmailExists(String email);
}
