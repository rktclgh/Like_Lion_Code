package com.sec02;

public class MessagePrinter {



    private final Message message;

    public MessagePrinter(Message message) {
        super();
        this.message = message;
    }

    public void print()
    {
        System.out.println(message.getMessage());
    }
}
