package com.work03.sec02;

public class RateDiscountPolicy implements DiscountPolicy{
    @Override
    public int getDiscountAmount(int price) {
        return price * 1/10;
    }
}
