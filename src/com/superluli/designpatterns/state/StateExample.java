package com.superluli.designpatterns.state;

public class StateExample {

    public static void main(String[] args) {
	
	StateMachine m = new StateMachine();
	System.out.println(m.current);
	m.action2();
	System.out.println(m.current);
	m.action3();
	System.out.println(m.current);
    }
}

interface State {

    void action1();

    void action2();

    void action3();
}

class State1 implements State {

    StateMachine m;

    State1(StateMachine m) {
	this.m = m;
    }

    @Override
    public void action1() {
	throw new RuntimeException("not allowed");
    }

    @Override
    public void action2() {
	m.current = m.S2;
    }

    @Override
    public void action3() {
	m.current = m.S3;
    }
}

class State2 implements State {

    StateMachine m;

    State2(StateMachine m) {
	this.m = m;
    }

    @Override
    public void action1() {
	m.current = m.S1;
    }

    @Override
    public void action2() {
	throw new RuntimeException("not allowed");
    }

    @Override
    public void action3() {
	m.current = m.S3;
    }
}

class State3 implements State {

    StateMachine m;

    State3(StateMachine m) {
	this.m = m;
    }

    @Override
    public void action1() {
	throw new RuntimeException("not allowed");
    }

    @Override
    public void action2() {
	throw new RuntimeException("not allowed");
    }

    @Override
    public void action3() {
	throw new RuntimeException("not allowed");
    }
}

class StateMachine implements State {

    State S1;
    State S2;
    State S3;

    State current;

    public StateMachine() {
	S1 = new State1(this);
	S2 = new State2(this);
	S3 = new State3(this);
	current = S1;
    }

    @Override
    public void action1() {
	current.action1();
    }

    @Override
    public void action2() {
	current.action2();
    }

    @Override
    public void action3() {
	current.action3();
    }
}
