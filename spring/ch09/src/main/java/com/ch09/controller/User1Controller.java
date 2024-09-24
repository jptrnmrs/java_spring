package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();
        return users;
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user = user1Service.selectUser1(uid);
        return user;
    }

    @ResponseBody
    @PostMapping("/user1")
    public ResponseEntity register(@RequestBody User1DTO user){
        log.info(user);
        User1 savedUser = user1Service.insertUser1(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }
    @ResponseBody
    @PutMapping("/user1")
    public ResponseEntity modify(@RequestBody User1DTO user){
        User1 modifiedUser = user1Service.updateUser1(user);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser);
    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        try{
            user1Service.deleteUser1(uid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(uid);

        }catch (Exception e){
            log.error(e);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }
}
