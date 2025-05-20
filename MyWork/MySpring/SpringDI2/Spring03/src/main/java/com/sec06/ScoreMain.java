package com.sec06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScoreMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application06.xml");
        Score score = ctx.getBean(Score.class);
        score.printScore();


        score = ctx.getBean("score",Score.class);
        score.printScore();
    }
}
