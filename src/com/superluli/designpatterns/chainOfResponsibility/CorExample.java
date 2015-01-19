package com.superluli.designpatterns.chainOfResponsibility;

public class CorExample {

    public static void main(String[] args) {
	
	Handler first = new Handler1(new Handler2(new Handler3(null)));
	first.handleRequest(new SimpleStringRequest("simple data"));
    }

}

interface Request {
    Object getData();
}

class SimpleStringRequest implements Request {

    String data;

    public SimpleStringRequest(String data) {
	this.data = data;
    }

    public Object getData() {
	return data;
    }
}

interface Handler {

    void handleRequest(Request request);
}

class Handler1 implements Handler {

    Handler successor;

    public Handler1(Handler successor) {
	this.successor = successor;
    }

    public void handleRequest(Request request) {
	System.out.println("this is handler 1, data is : " + request.getData());
	if (successor != null) {
	    successor.handleRequest(request);
	}
    }
}

class Handler2 extends Handler1 {
    public Handler2(Handler successor) {
	super(successor);
    }

    public void handleRequest(Request request) {
	System.out.println("this is handler 2, data is : " + request.getData());
	if (successor != null) {
	    successor.handleRequest(request);
	}
    }
}

class Handler3 extends Handler1 {
    public Handler3(Handler successor) {
	super(successor);
    }

    public void handleRequest(Request request) {
	System.out.println("this is handler 3, data is : " + request.getData());
	if (successor != null) {
	    successor.handleRequest(request);
	}
    }
}
