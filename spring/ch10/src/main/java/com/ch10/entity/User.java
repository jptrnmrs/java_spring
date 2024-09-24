package com.ch10.entity;

import com.ch10.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@ToString
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String birth;
    private String role;


    @CreatedDate
    private LocalDateTime rdate;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .username(username)
                .password(password)
                .name(name)
                .birth(birth)
                .role(role)
                .rdate(rdate)
                .build();
    }
}
