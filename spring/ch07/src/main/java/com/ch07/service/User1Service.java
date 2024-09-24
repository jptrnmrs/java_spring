package com.ch07.service;

import com.ch07.DTO.User1DTO;
import com.ch07.entity.User1;
import com.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void insertUser1(User1DTO user1DTO) {
        user1Repository.save(user1DTO.toEntity());
    }
    public User1DTO selectUser1(String uid) {
        Optional<User1> opt = user1Repository.findById(uid);
        if (opt.isPresent()) {
            User1 user1 = opt.get();
            return user1.toDTO();
        }
        return null;
    }
    public List<User1DTO> selectUser1s() {
        List<User1> list = user1Repository.findAll();
        List<User1DTO> dtos = list.stream()
                            .map(entity -> entity.toDTO())
                            .collect(Collectors.toList());
        return dtos;
    }
    public void updateUser1(User1DTO user1DTO) {
        boolean result = user1Repository.existsById(user1DTO.getUid());
        if (result) {
            user1Repository.save(user1DTO.toEntity());
        }
    }
    public void deleteUser1(String uid) {
        user1Repository.deleteById(uid);
    }


}
