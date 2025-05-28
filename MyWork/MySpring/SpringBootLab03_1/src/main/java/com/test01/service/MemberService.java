package com.test01.service;


import com.test01.entity.Member;
import com.test01.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {


    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public Member register(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.save(member);
    }

    public List<Member> getTop5Members() {
        return memberRepository.findTop5ByOrderByIdDesc();
    }

}
