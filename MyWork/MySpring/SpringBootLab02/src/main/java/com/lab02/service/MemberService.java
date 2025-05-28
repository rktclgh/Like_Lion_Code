package com.lab02.service;


import com.lab02.entity.Member;
import com.lab02.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers()
    {
        return memberRepository.findAll();
    }


    public Member getMemberById(Long id)
    {
    return memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Member not found"));
    }

    public Member saveMember(Member member)
    {
        return memberRepository.saveAndFlush(member);
    }

    public Member updateMember(Long id, Member member)
    {
        Member existing  = getMemberById(id);
        existing.setName(member.getName());
        existing.setEmail(member.getEmail());
        return memberRepository.saveAndFlush(existing);
    }

    public void deleteMember(Long id)
    {
        memberRepository.deleteById(id);
    }

}
