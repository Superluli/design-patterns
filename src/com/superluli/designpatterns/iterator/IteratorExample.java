package com.superluli.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {
	MyCollection<String> col = new MyCollection<String>(Arrays.asList("1", "2", "3"));
	
	Iterator<String> itr = col.iterator();
	System.out.println(itr.next());
	System.out.println(itr.next());
	for(String s : col){
	    System.out.println(s);
	}
	System.out.println(Object[].class);
	
    }
}

class MyCollection<T> implements Iterable<T> {

    private List<T> list;

    public MyCollection(List<T> values) {
	this.list = new ArrayList<T>(values);
    }

    @Override
    public Iterator<T> iterator() {
	return new Itr();
    }
    
    class Itr implements Iterator<T>{

	private int cursor;
	
	@Override
	public boolean hasNext() {
	    return cursor != list.size();
	}

	@Override
	public T next() {
	    return list.get(cursor++);
	}	
    }
}
