package com.work01.sec04;

import org.springframework.stereotype.Component;

@Component("eveningGreet")
public class EveningGreet implements Greet{
    @Override
    public String greeting() {
        return "안녕하세요 (저녁인사)";
    }
}
