package com.test03.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
//    @GetMapping("/logout")
//    public String index() {
//        return "index";
//    }


    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    @GetMapping("/PUBLIC")
    public String PUBLIC() {
        return "public";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
