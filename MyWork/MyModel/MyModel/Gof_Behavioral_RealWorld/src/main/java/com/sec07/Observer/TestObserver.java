package com.sec07.Observer;

import java.util.*;

interface Observer { void update(); }

class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void add(Observer o) { observers.add(o); }
    public void notifyAllObservers() { for (Observer o : observers) o.update(); }
}

class ConcreteObserver implements Observer {
    public void update() { System.out.println("Notified!"); }
}

public class TestObserver {
    public static void main(String[] args) {
        Subject s = new Subject();
        s.add(new ConcreteObserver());
        s.notifyAllObservers();
    }
}
