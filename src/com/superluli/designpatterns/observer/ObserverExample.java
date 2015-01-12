package com.superluli.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {

    public static void main(String[] args) {
	
	EventProducer producer = new SimpleEventProducer();
	producer.subscribe(new SimpleObserver1());
	producer.subscribe(new SimpleObserver2());
	producer.onUpdate(new Event() {
	    @Override
	    public Object getContent() {
		return "breaking news!";
	    }
	});
    }
}

interface EventProducer {
    public void subscribe(Observer observer);

    public void unsubscribe(Observer observer);

    public void onUpdate(Event event);
}

interface Event {
    public Object getContent();
}

interface Observer {
    public void onReceive(Event event);
}

class SimpleEventProducer implements EventProducer {

    private List<Observer> observers;

    public SimpleEventProducer() {
	observers = new ArrayList<Observer>();
    }

    @Override
    public void subscribe(Observer observer) {
	observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
	observers.remove(observer);
    }

    @Override
    public void onUpdate(Event event) {
	for (Observer o : observers) {
	    o.onReceive(event);
	}
    }
}

class SimpleObserver1 implements Observer {

    @Override
    public void onReceive(Event event) {

	System.out.println(this.getClass().getSimpleName() + " received " + event.getContent());
    }
}

class SimpleObserver2 implements Observer {

    @Override
    public void onReceive(Event event) {

	System.out.println(this.getClass().getSimpleName() + " received " + event.getContent());
    }
}
