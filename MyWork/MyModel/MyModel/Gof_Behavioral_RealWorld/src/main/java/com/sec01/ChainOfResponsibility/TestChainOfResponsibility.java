package com.sec01.ChainOfResponsibility;

abstract class Handler {
    protected Handler next;
    public void setNext(Handler next) { this.next = next; }
    public abstract void handle(int level);
}

class LowLevelHandler extends Handler {
    public void handle(int level) {
        if (level <= 1) System.out.println("Handled by LowLevel");
        else if (next != null) next.handle(level);
    }
}

class HighLevelHandler extends Handler {
    public void handle(int level) {
        if (level <= 2) System.out.println("Handled by HighLevel");
        else System.out.println("Request too high");
    }
}

public class TestChainOfResponsibility {
    public static void main(String[] args) {
        Handler h1 = new LowLevelHandler();
        Handler h2 = new HighLevelHandler();
        h1.setNext(h2);
        h1.handle(1);
    }
}
