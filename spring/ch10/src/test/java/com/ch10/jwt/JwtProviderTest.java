package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {
        User user = User.builder()
                .username("a101")
                .name("김유신")
                .birth("1990-09-01")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user,1);
        System.out.println(jwt);

    }

    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1bmRlcjkxMkBuYXZlci5jb20iLCJpYXQiOjE3MjYxMjI5MDgsImV4cCI6MTcyNjIwOTMwOCwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.aVoYmsuJnfRgThdJS_rFnZJ24abktldD1pslHYehxCc";
        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");
        System.out.println(username+", "+role);
    }

    @Test
    void getAuthentication() {

    }

    @Test
    void validateToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1bmRlcjkxMkBuYXZlci5jb20iLCJpYXQiOjE3MjYxMjI5MDgsImV4cCI6MTcyNjEyMjkwOCwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.-OFmaqIA7y0pRAiUAdXbNrWxMii-DAyg6_hSqvH-gcA";
        try {
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}