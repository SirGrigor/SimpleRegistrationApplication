package com.registration.entain.service;

import com.registration.entain.domain.User;
import com.registration.entain.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAllUsers();
    User findByEmail(String email);

    User save(UserDTO registration);

    Boolean existsByEmail(String email);
}
