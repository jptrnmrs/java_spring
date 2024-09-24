package com.ch08.service;

import com.ch08.dto.UserDTO;
import com.ch08.entity.User;
import com.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(UserDTO user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user.toEntity());
    }

    public UserDTO selectUser(String username) {
        Optional<User> opt = userRepository.findById(username);
        if(opt.isPresent()) {
            User user = opt.get();
            return user.toDTO();
        }
        return null;
    }

}
