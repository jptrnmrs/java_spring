package com.ch06.service;

import com.ch06.dto.User1DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    @Order(1)
    @DisplayName("User1 등록")
    void insertUser1() {
        User1DTO sample = User1DTO.builder()
                .uid("a205")
                .name("김유신")
                .birth("1990-09-02")
                .hp("010-1234-1234")
                .age(32)
                .build();

        user1Service.insertUser1(sample);

        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    @Order(2)
    void selectUser1() {
        // given
        String uid = "a205";
        // when
        User1DTO expected = user1Service.selectUser1(uid);
        Assertions.assertEquals(expected.getUid(), uid);
    }

    @Test
    @Order(3)
    void selectUser1s() {
        List<User1DTO> expected = user1Service.selectUser1s();
        Assertions.assertFalse(expected.isEmpty());
    }
    @Test
    @Order(4)
    void updateUser1() {

        User1DTO sample = User1DTO.builder()
                .uid("a205")
                .name("김유정")
                .birth("1990-09-02")
                .hp("010-1234-1234")
                .age(32)
                .build();
        user1Service.updateUser1(sample);
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    @Order(5)
    void deleteUser1() {
        String uid = "a205";
        user1Service.deleteUser1(uid);
        User1DTO expected = user1Service.selectUser1(uid);
        Assertions.assertNull(expected);
    }
}
