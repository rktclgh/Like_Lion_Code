import com.work03.sec03.*

beans {
    memberRepository(MemoryMemberRepository) {
        save(1, "Kanye West")
    }

    discountPolicy(FixDiscountPolicy)

    orderService(OrderServiceImpl, ref("memberRepository"), ref("discountPolicy"))
}
