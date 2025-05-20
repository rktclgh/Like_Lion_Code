package com.work03.sec03;

public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int getDiscountAmount(int price) {
        return 1000;
    }
}
