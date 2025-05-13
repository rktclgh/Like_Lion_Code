package com.sec06.Memento;

class Memento {
    private String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}

class Originator {
    private String state;
    public void setState(String state) { this.state = state; }
    public Memento save() { return new Memento(state); }
    public void restore(Memento m) { state = m.getState(); }
    public void show() { System.out.println("State: " + state); }
}

public class TestMemento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("A");
        Memento m = originator.save();
        originator.setState("B");
        originator.restore(m);
        originator.show();
    }
}
