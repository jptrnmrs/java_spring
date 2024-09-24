package com.ch10.dto;

import com.ch10.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {
    private String username;

    private String password;

    private String name;
    private String birth;
    private String role;
    private LocalDateTime rdate;

    public User toEntity() {
        User user = User.builder()
                .username(username)
                .password(password)
                .name(name)
                .birth(birth)
                .role(role)
                .rdate(rdate)
                .build();
        return user;
    }
}
