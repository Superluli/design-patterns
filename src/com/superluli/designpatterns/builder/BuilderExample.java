package com.superluli.designpatterns.builder;

public class BuilderExample {

    public static void main(String[] args) {
	/*
	 * Lagacy builder style
	 */
	System.out.println(CarBuilder.startBuiding().addBody("CF").addEngine("V6").addTire("PSS")
		.finishBuiding());
	/*
	 * Jax-rs Response style
	 */
	System.out.println(Car2.startBuiding().addBody("CF").addEngine("V6").addTire("PSS")
		.finishBuiding());
    }
}

class CarBuilder {

    Car car;

    private CarBuilder() {
	car = new Car();
    }

    static CarBuilder startBuiding() {
	return new CarBuilder();
    }

    CarBuilder addBody(String body) {
	car.body = body;
	return this;
    }

    CarBuilder addTire(String tire) {
	car.tire = tire;
	return this;
    }

    CarBuilder addEngine(String engine) {
	car.engine = engine;
	return this;
    }

    Car finishBuiding() {
	return car;
    }

    static class Car {

	@Override
	public String toString() {
	    return "Car [body=" + body + ", tire=" + tire + ", engine=" + engine + "]";
	}
	String body;
	String tire;
	String engine;
    }
}

class Car2 {

    @Override
    public String toString() {
	return "Car2 [body=" + body + ", tire=" + tire + ", engine=" + engine + "]";
    }

    String body;
    String tire;
    String engine;

    static CarBuilder2 startBuiding() {
	return new CarBuilder2();
    }

    static class CarBuilder2 {

	Car2 car;

	private CarBuilder2() {
	    car = new Car2();
	}

	CarBuilder2 addBody(String body) {
	    car.body = body;
	    return this;
	}

	CarBuilder2 addTire(String tire) {
	    car.tire = tire;
	    return this;
	}

	CarBuilder2 addEngine(String engine) {
	    car.engine = engine;
	    return this;
	}

	public Car2 finishBuiding() {
	    return car;
	}
    }
}
