package com.lab02.repository;


import com.lab02.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
