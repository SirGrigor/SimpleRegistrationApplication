package dto;


import domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mapper {
    public UserDTO userDTO(Optional<User> user) {
        UserDTO dto = new UserDTO();

        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthday(user.getBirthday());
        dto.setId(user.getId());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setBirthday(userDTO.getBirthday());
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
