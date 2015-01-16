package com.superluli.designpatterns.adapter;

public class AdapterExample {

    public static void main(String[] args) {
	
	NewInterface newObj = new NewClass();
	newObj.newFunc();
	NewInterface newInterfaceAdapter = new NewInterfaceAdapter(new OldClass());
	newInterfaceAdapter.newFunc();
    }

    interface NewInterface{
	
	public void newFunc();
    }
    
    static class NewClass implements NewInterface{

	public void newFunc() {
	    System.out.println("New func");
	}
    }
    
    static class OldClass{
	
	public void oldFunc(){
	    System.out.println("Old func");
	}
    }
    
    static class NewInterfaceAdapter implements NewInterface{

	OldClass oldObj;
	
	private NewInterfaceAdapter(OldClass oldObj){
	    this.oldObj = oldObj;
	}
	
	public void newFunc() {
	    
	    oldObj.oldFunc();
	}
    }
}
