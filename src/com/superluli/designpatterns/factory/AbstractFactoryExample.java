package com.superluli.designpatterns.factory;

public class AbstractFactoryExample {

    public static void main(String[] args) {
	CommonFactory fac = new CommonFactoryImpl();
	System.out.println(fac.orderApple().getInfo());
	System.out.println(fac.orderPizza().getInfo());
	System.out.println(fac.orderDrink().getInfo());
    }

    interface CommonFactory {

	public Pizza orderPizza();
	public Drink orderDrink();
	public Apple orderApple();
    }

    static class CommonFactoryImpl implements CommonFactory{

	@Override
	public Pizza orderPizza() {
	    return new Pizza();
	}

	@Override
	public Drink orderDrink() {
	    return new Drink();
	}

	@Override
	public Apple orderApple() {
	    return new Apple();
	}
	
    }
    
    abstract static class Product {
	abstract String getInfo();
    }

    static class Pizza extends Product {

	@Override
	String getInfo() {
	    return "Pizza!";
	}
    }

    static class Drink extends Product {
	@Override
	String getInfo() {
	    return "Drink!";
	}
    }

    static class Apple extends Product {
	@Override
	String getInfo() {
	    return "Apple!";
	}
    }
}
