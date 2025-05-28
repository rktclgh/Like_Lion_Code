package com.test01.service;

import com.test01.entity.Member;
import com.test01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
//@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
public UserDetails loadUserByUsername(String username) throws
        UsernameNotFoundException {
    Member member = memberRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    return User.builder()
            .username(member.getUsername())
            .password(member.getPassword())
            .roles(member.getRole().replace("ROLE_", ""))
            .build();
}
}
