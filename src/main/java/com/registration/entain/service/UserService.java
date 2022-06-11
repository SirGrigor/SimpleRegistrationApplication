package com.registration.entain.service;

import com.registration.entain.domain.User;
import com.registration.entain.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    void save(UserDTO UserDTO);

    void updateUser(Long id, UserDTO userDTO);

    UserDTO findById(Long id);

    String getCurrentLoggedInUser();

}
