package com.sec02.Bridge;
public abstract class Message {
    protected MessageSender sender;
    protected Message(MessageSender sender) {
        this.sender = sender;
    }
    public abstract void send(String text);
}
