package com.work03.sec02;

public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int getDiscountAmount(int price) {
        return 1000;
    }
}
