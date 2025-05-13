package com.sec04.Decorator;
public class SlackDecorator implements Notifier {

    private final Notifier wrappee;


    // Decorator 패턴
    public SlackDecorator(Notifier wrappee)
    {
        this.wrappee = wrappee;
    }
    public void send() {

        wrappee.send();
        System.out.println("Also sending via Slack");
    }
}
