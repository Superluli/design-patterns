package com.superluli.designpatterns.factory;

public class FactoryMethodExample {

    public static void main(String[] args){
	CommonPizzaFactory fac1 = new PizzaFactory1();
	CommonPizzaFactory fac2 = new PizzaFactory2();
	System.out.println(fac1.orderPizza().getInfo());
	System.out.println(fac2.orderPizza().getInfo());
    }
    
    static abstract class CommonPizzaFactory {

	public abstract Pizza orderPizza();
    }

    static class PizzaFactory1 extends CommonPizzaFactory {

	@Override
	public Pizza orderPizza() {
	    return new Pizza(true);
	}

    }

    static class PizzaFactory2 extends CommonPizzaFactory {

	@Override
	public Pizza orderPizza() {
	    return new Pizza(false);
	}

    }

    static class Pizza {

	private boolean withOnion;

	public Pizza(boolean withOnion) {
	    this.withOnion = withOnion;
	}

	public String getInfo() {
	    return "Best pizza! " + "with onion : " + withOnion;
	}
    }
}
