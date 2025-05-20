package com.work03.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository()
    {
        MemoryMemberRepository repository = new MemoryMemberRepository();
        repository.save(1,"홍길동");
        return repository;
    }

    @Bean
    public DiscountPolicy discountPolicy()
    {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService()
    {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
