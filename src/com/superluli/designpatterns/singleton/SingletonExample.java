package com.superluli.designpatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonExample {

    public static void main(String[] args) {

	ExecutorService executorService = Executors.newFixedThreadPool(10000);
	final SingletonEnum sin2 = SingletonEnum.INSTANCE;

	for (int i = 0; i < 10000; i++) {
	    executorService.execute(new Runnable() {
		@Override
		public void run() {

		    SingletonDoubleLock.getInstance();
		    if (SingletonEnum.getInstance() != sin2) {
			System.out.println("2 fake!");
		    }
		}
	    });
	}
	executorService.shutdown();
    }
}

/*
 * Lazy, synchronized
 */

class SingletonSync {

    private static SingletonSync instance = null;

    private SingletonSync() {
    }

    public static synchronized SingletonSync getInstance() {
	if (instance == null) {
	    instance = new SingletonSync();
	}

	return instance;
    }
}

/*
 * Lazy, double checked locking, volatile is required
 */
class SingletonDoubleLock {

    private static volatile SingletonDoubleLock instance;

    private SingletonDoubleLock() {

    }

    public static SingletonDoubleLock getInstance() {
	if (instance == null) {
	    synchronized (SingletonDoubleLock.class) {
		if (instance == null) {
		    instance = new SingletonDoubleLock();
		    System.out.println("new instance!");
		}
	    }
	}
	return instance;
    }
}

/*
 * Eager initialization
 */

class SingletonStaticInstance {
    private static final SingletonStaticInstance INSTANCE = new SingletonStaticInstance();

    private SingletonStaticInstance() {
    }

    public static SingletonStaticInstance getInstance() {
	return INSTANCE;
    }
}

/*
 * Eager initialization, in static block
 */
class SingletonStaticBlock {
    private static SingletonStaticBlock INSTANCE;
    static {
	/*
	 * do some other logics like exception handling, etc...
	 */
	try {
	    INSTANCE = new SingletonStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Darn, an error occurred!", e);
        }
    }

    private SingletonStaticBlock() {
    }

    public static SingletonStaticBlock getInstance() {
	return INSTANCE;
    }
}

/*
 * Lazy initialization on demand holder
 */
class SingletonOnDemandHolder {
    static class Holder {
	private static final SingletonOnDemandHolder INSTANCE = new SingletonOnDemandHolder();
    }

    private SingletonOnDemandHolder() {

    }

    public static SingletonOnDemandHolder getInstance() {
	return Holder.INSTANCE;
    }
}

/*
 * Enum way
 */
enum SingletonEnum {
    INSTANCE;
    public static SingletonEnum getInstance() {
	return INSTANCE;
    }
}
