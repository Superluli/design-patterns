package com.superluli.designpatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonExample {

    public static void main(String[] args) {

	ExecutorService executorService = Executors.newFixedThreadPool(10000);
	final Singleton2 sin2 = Singleton2.INSTANCE;

	for (int i = 0; i < 10000; i++) {
	    executorService.execute(new Runnable() {
		@Override
		public void run() {

		    Singleton.getInstance();
		    if (Singleton2.getInstance() != sin2) {
			System.out.println("2 fake!");
		    }
		}
	    });
	}
	executorService.shutdown();
    }
}

class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
	if (instance == null) {
	    synchronized (Singleton.class) {
		if (instance == null) {
		    instance = new Singleton();
		    System.out.println("new instance!");
		}
	    }
	}
	return instance;
    }
}

enum Singleton2 {
    INSTANCE;
    public static Singleton2 getInstance() {
	return INSTANCE;
    }
}

class Singleton3 {
    private static Singleton3 INSTANCE;
    static {
	INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
	return INSTANCE;
    }
}
