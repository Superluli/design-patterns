package com.superluli.designpatterns.adapter.builder;

public class BuilderExample {

    static class CarBuilder {

	Car car;

	CarBuilder() {
	    car = new Car();
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

	CarBuilder addSuspension(String suspension) {
	    car.suspension = suspension;
	    return this;
	}

	Car build() {
	    return car;
	}

	static class Car {
	    @Override
	    public String toString() {
		return "Car [body=" + body + ", tire=" + tire + ", engine=" + engine
			+ ", suspension=" + suspension + "]";
	    }

	    String body;
	    String tire;
	    String engine;
	    String suspension;
	}
    }

    public static void main(String[] args) {
	System.out.println(new CarBuilder().addBody("CF").addEngine("V6").addTire("PSS")
		.addSuspension("Multilink").build());
    }
}
