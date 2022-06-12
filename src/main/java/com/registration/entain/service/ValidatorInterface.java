package com.registration.entain.service;

public interface ValidatorInterface {

    Boolean checkPassword(String password, String confirmedPassword);

    Boolean checkEmail(String email, String confirmedEmail);

    Boolean checkEmailExists(String email);
}
