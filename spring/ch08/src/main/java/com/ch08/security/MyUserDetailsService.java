package com.ch08.security;

import com.ch08.dto.UserDTO;
import com.ch08.entity.User;
import com.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> opt = userRepository.findById(username);
        if(opt.isPresent()) {

            MyUserDetails myUserDetails = MyUserDetails.builder()
                                                .user(opt.get())
                                                .build();

            return myUserDetails;
        }
        return null;

    }
}
