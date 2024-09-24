package com.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/","/index"})
    public String index(Model model) {

        return "index";
    }
    @GetMapping(value = {"/admin/","/admin/index"})
    public String admin(){
        return "admin/index";
    }
    @GetMapping(value = {"/manager/","/manager/index"})
    public String manager(){
        return "manager/index";
    }
    @GetMapping(value = {"/staff/","/staff/index"})
    public String staff(){
        return "staff/index";
    }
}
