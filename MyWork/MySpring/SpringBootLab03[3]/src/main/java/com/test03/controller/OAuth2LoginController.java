package com.test03.controller;

import com.test03.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2LoginController {
    @Autowired
    private MemberService memberService;
    public OAuth2LoginController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User
                               oauth2User) {
        memberService.saveOrUpdateMember(oauth2User);
        return "home";
    }
}