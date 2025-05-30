package com.sec01.service;


import com.sec01.entity.Member;
import com.sec01.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public String createMember(String username, String email) {
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        memberRepository.save(member);
        return "success";
    }



}
