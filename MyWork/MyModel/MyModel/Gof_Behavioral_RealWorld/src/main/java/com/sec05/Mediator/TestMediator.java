package com.sec05.Mediator;

class Mediator {
    public void notify(String msg) {
        System.out.println("Mediator relays: " + msg);
    }
}

class Component {
    private Mediator mediator;
    public Component(Mediator mediator) { this.mediator = mediator; }
    public void action() { mediator.notify("Action triggered"); }
}

public class TestMediator {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Component comp = new Component(mediator);
        comp.action();
    }
}
