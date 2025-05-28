package com.test01.controller;


import com.test01.entity.Member;
import com.test01.repository.MemberRepository;
import com.test01.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {


    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String index()
    {
        return "index";
    }
    @GetMapping("/register")
    public String registerForm(Model model)
    {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Member member)
    {
        memberService.register(member);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm()
    {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model)
    {
        List<Member> members = memberRepository.findTop5ByOrderByIdDesc();
        model.addAttribute("members", members);
        return "home";
    }


    List<Member> getAllMembers()
    {
        return  null;
    }



}
