package com.superluli.designpatterns.templatemethod;

public class TemplateMethodExample {
    
    public static void main(String[] args){
	new ProcedureInvokerImpl1().process();
	new ProcedureInvokerImpl2().process();
    }
}

abstract class ProcedureInvoker{
    
    final void process(){
	step1();
	step2();
	step3();
    }
    
    //fixed
    final void step1(){
	System.out.println("step1, fixed");
    }
    
    //default, but can be changed
    void step2(){
	System.out.println("step2, default");
    }
    
    //must be specific
    abstract void step3();
}

class ProcedureInvokerImpl1 extends ProcedureInvoker{

    @Override
    void step3() {
	System.out.println("step3, ProcedureInvokerImpl1");
    }
}

class ProcedureInvokerImpl2 extends ProcedureInvoker{

    @Override
    void step2(){
	System.out.println("step2, ProcedureInvokerImpl2");
    }
    
    @Override
    void step3() {
	System.out.println("step3, ProcedureInvokerImpl2");
    }
}
