package com.work01.sec06;

import org.springframework.stereotype.Component;

@Component
public class EveningGreet implements Greet{
    public String greeting() {
        return "안녕하세요 (저녁 인사)";
    }
}
