package com.work01.sec05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class GreetService {

    private  Greet greet;
    @Autowired
    public void setGreet(Greet greet)
    {
        this.greet = greet;
    }


    public void sayHello()
    {
        System.out.println(greet.greeting());
    }

}
