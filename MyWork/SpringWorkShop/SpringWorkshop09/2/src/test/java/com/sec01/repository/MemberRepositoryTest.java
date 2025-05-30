package com.sec01.repository;

import com.sec01.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testSaveAndFindById() {
        // given
        Member member = new Member();
        member.setUsername("testuser");
        member.setEmail("testuser@example.com");
        member.setCreatedDate(LocalDateTime.now());

        // when
        Member savedMember = memberRepository.save(member);
        Optional<Member> foundMember =
                memberRepository.findById(savedMember.getId());

        // then
        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getUsername()).isEqualTo("testuser");
        assertThat(foundMember.get().getEmail()).isEqualTo("testuser@example.com");
    }
}

