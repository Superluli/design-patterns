package com.superluli.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample {

    public static void main(String[] args) {

	final IRealObject realObj = new RealObject();

	IRealObject proxyObj1 = getGeneralProxy(realObj, new InvocationHandler() {

	    @Override
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().contains("method1")){
		    throw new IllegalAccessError("method1 is not allowed");
		}
		return method.invoke(realObj, args);
	    }
	});
	
	IRealObject proxyObj2 = getGeneralProxy(realObj, new InvocationHandler() {

	    @Override
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().contains("method2")){
		    throw new IllegalAccessError("method2 is not allowed");
		}
		return method.invoke(realObj, args);
	    }
	});
	
	proxyObj1.method1();
	proxyObj1.method2();
	proxyObj2.method1();
	proxyObj2.method2();
    }

    @SuppressWarnings("unchecked")
    public static <T> T getGeneralProxy(final T realObj, InvocationHandler handler) {
	Class<?> clazz = realObj.getClass();
	return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
    }
}

interface IRealObject {

    public void method1();

    public void method2();
}

class RealObject implements IRealObject {

    @Override
    public void method1() {
	System.out.println(this + " realMethod1");
    }

    @Override
    public void method2() {
	System.out.println(this + " realMethod2");
    }
}

class RealObjectInvocationHandler implements InvocationHandler {

    IRealObject realObj;

    public RealObjectInvocationHandler(IRealObject realObj) {
	this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

	return method.invoke(realObj, args);
    }
}
