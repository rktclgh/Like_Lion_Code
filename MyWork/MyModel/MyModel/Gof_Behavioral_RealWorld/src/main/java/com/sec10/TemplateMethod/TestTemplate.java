package com.sec10.TemplateMethod;

abstract class Meal {
    public final void prepareMeal() {
        prepareIngredients();
        cook();
        serve();
    }
    abstract void prepareIngredients();
    abstract void cook();
    void serve() { System.out.println("Serving meal"); }
}

class Pasta extends Meal {
    void prepareIngredients() { System.out.println("Preparing pasta ingredients"); }
    void cook() { System.out.println("Cooking pasta"); }
}

public class TestTemplate {
    public static void main(String[] args) {
        Meal meal = new Pasta();
        meal.prepareMeal();
    }
}
