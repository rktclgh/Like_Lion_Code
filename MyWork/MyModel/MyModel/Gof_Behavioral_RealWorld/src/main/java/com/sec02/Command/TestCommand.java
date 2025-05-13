package com.sec02.Command;

interface Command {
    void execute();
}

class Light {
    void turnOn() { System.out.println("Light On"); }
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

public class TestCommand {
    public static void main(String[] args) {
        Light light = new Light();
        Command cmd = new LightOnCommand(light);
        cmd.execute();
    }
}
