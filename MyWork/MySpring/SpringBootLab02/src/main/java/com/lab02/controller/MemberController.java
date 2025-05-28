package com.lab02.controller;


import com.lab02.entity.Member;
import com.lab02.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers()
    {
        return memberService.getAllMembers();
    }
    @GetMapping("/{id}")
    Member getMemberById(@PathVariable Long id)
    {
        return memberService.getMemberById(id);
    }
    @PostMapping
    Member createMember(@Valid @RequestBody Member member)
    {
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    Member updateMember(@PathVariable Long id,@Valid @RequestBody Member member)
    {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    void deleteMember(Long id)
    {
        memberService.deleteMember(id);
    }
}
