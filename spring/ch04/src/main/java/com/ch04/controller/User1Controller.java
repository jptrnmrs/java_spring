package com.ch04.controller;

import com.ch04.dto.User1DTO;
import com.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User1Controller {

    private User1Service service;

    @Autowired
    public User1Controller(User1Service service) {
        this.service = service;
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }
    @PostMapping("/user1/register")
    public String register(User1DTO dto){
        service.insertUser1(dto);
        return "redirect: /ch04/user1/list";
    }

    @GetMapping("/user1/list")
    public String list(Model model){

        List<User1DTO> users = service.selecttUser1s();
        System.out.println(users);
        // 모델참조
        model.addAttribute("users",users);

        return "/user1/list";
    }
    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        System.out.println("uid : " + uid);
        User1DTO user = service.selectUser1(uid);
        // 모델참조
        model.addAttribute(user); // 타입명으로 저장 (소문자시작

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(@ModelAttribute User1DTO dto) {
        service.updateUser1(dto);
        return "redirect: /ch04/user1/list";
    }
    @GetMapping("/user1/delete")
    public String delete(User1DTO dto) {
        service.deleteUser1(dto.getUid());
        return "redirect: /ch04/user1/list";
    }

}
