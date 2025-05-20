package com.work01.sec04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetService {
    private final Greet greet;

    @Autowired
    public GreetService(@Qualifier("eveningGreet") Greet greet) {
        this.greet = greet;
    }

    public void sayHello()
    {
        System.out.println(greet.greeting());
    }
}
