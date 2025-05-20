package com.work01.sec05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetManager {

    private GreetService greetService;
    @Autowired
    public void setService(GreetService greetService) {
        this.greetService = greetService;
    }


    public void execute()
    {
        greetService.sayHello();
    }
}
