package service;

import domain.User;
import dto.Mapper;
import dto.UserDTO;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    public RegistrationService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public void saveUser(UserDTO userDTO) {
        userRepository.save(mapper.toUser(userDTO));
    }

    public UserDTO getUserById(UserDTO userDTO) {
        User user;
        user = mapper.toUser(userDTO);
        return mapper.userDTO(userRepository.findById(user.getId()));
    }

}
