package com.superluli.designpatterns.factory;

public class FactoryExample {

    public static void main(String[] args) {
	Pizza pizza = new SimplePizzaFactory().orderPizza();
	System.out.println(pizza.getInfo());
    }

    static class SimplePizzaFactory {

	public Pizza orderPizza() {
	    return new Pizza();
	}
    }

    static class Pizza {

	public String getInfo() {
	    return "Best pizza!";
	}
    }
}
