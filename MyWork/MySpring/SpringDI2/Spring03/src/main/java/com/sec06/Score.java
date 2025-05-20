package com.sec06;

import org.springframework.stereotype.Component;

@Component // 나 score 라는 Bean이야
public class Score {
    public void printScore()
    {
        System.out.println("Score component!!!");
    }
}
