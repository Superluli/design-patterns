package com.superluli.designpatterns.decorator;

public class DecoratorExample {

    public static void main(String[] args) {
	Component com = new ComponentDecorator1(new ComponentDecorator2(new ComponentDecorator3(
		new Component1())));
	System.out.println(com);
    }
}

abstract class Component {

    public void method1() {

    }

    public abstract void method2();
}

class Component1 extends Component {

    @Override
    public String toString() {
	return "Component1";
    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub

    }
}

class Component2 extends Component {

    @Override
    public String toString() {
	return "Component2";
    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub
    }
}

abstract class ComponentDecorator extends Component {

}

class ComponentDecorator1 extends ComponentDecorator {

    private Component wrapped;

    public ComponentDecorator1(Component wrapped) {
	this.wrapped = wrapped;
    }

    @Override
    public String toString() {
	return "ComponentDecorator1 [wrapped=" + wrapped + "]";
    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub

    }

}

class ComponentDecorator2 extends ComponentDecorator {

    private Component wrapped;

    public ComponentDecorator2(Component wrapped) {
	this.wrapped = wrapped;
    }

    @Override
    public String toString() {
	return "ComponentDecorator2 [wrapped=" + wrapped + "]";
    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub

    }

}

class ComponentDecorator3 extends ComponentDecorator {

    private Component wrapped;

    public ComponentDecorator3(Component wrapped) {
	this.wrapped = wrapped;
    }

    @Override
    public String toString() {
	return "ComponentDecorator3 [wrapped=" + wrapped + "]";
    }

    @Override
    public void method2() {
	// TODO Auto-generated method stub

    }

}
