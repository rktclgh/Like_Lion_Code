package com.sec05.Facade;
public class CarFacade {
    private final Engine engine = new Engine();
    private final Lights lights = new Lights();

    public void startCar() {
        lights.turnOn();
        engine.start();
    }
}
