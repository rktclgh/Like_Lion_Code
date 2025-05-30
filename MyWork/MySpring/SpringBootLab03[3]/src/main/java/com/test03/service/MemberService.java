package com.test03.service;


import com.test03.entity.Member;
import com.test03.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void saveOrUpdateMember(OAuth2User oauth2User) {
        //구글의 Authentication.getPrincipal() 현재 인증된 사용자 정보를 OAuth2User로 받아서
        // Member 객체에 담아 DB로 저장


        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");

        Member member = memberRepository.findByUsername(email)
                .orElse(new Member());

//        member.setUsername(email);// 중복 방지
        member.setUsername(name);

        // 새로운 사용자라면 oauth2user
        if (member.getPassword() == null) {
            member.setPassword("oauth2user");
        }

        memberRepository.save(member);
        System.out.println("저장된 사용자: " +
                member.getUsername());
    }
}