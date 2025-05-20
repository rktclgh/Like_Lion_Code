package com.work03.sec01;

public class FixDiscountPolicy implements DiscountPolicy{
    @Override
    public int getDiscountAmount(int price) {
        return 1000;
    }
}
