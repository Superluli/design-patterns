package com.superluli.designpatterns.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CompositeExample {
    public static void main(String[] args) {
	Node root = new Node("0").addChildren(
		new Node("00").addChildren(new Node("000"), new Node("001")), new Node("01"),
		new Node("02").addChildren(new Node("020"), new Node("021")));

	// root = new Node("0").addChildren(new Node("00").addChildren(new
	// Node("000")), new Node("01"));

	printIterator(root);
    }

    public static void printIterator(Node root) {
	Iterator<Node> comItr = new CompositeDFSIterator(root);
	while (comItr.hasNext()) {
	    System.out.println(comItr.next().getName());
	}
	
	comItr = new CompositeBFSIterator(root);
	while (comItr.hasNext()) {
	    System.out.println(comItr.next().getName());
	}
    }
}

class Node implements Iterable<Node> {

    private List<Node> children;

    private String name;

    public Node(String name) {
	this.name = name;
	this.children = new ArrayList<Node>();
    }

    public Node addChildren(Node... nodes) {
	children.addAll(Arrays.asList(nodes));
	return this;
    }

    public String getName() {
	return name;
    }

    @Override
    public Iterator<Node> iterator() {

	return children.iterator();
    }
}

class CompositeDFSIterator implements Iterator<Node> {

    private Stack<Iterator<Node>> stack;

    public CompositeDFSIterator(Node root) {
	stack = new Stack<Iterator<Node>>();
	stack.push(new Node(null).addChildren(root).iterator());
    }

    @Override
    public boolean hasNext() {
	return !stack.isEmpty();
    }

    @Override
    public Node next() {
	if (hasNext()) {
	    Iterator<Node> currentItr = stack.peek();
	    Node nextNode = currentItr.next();
	    stack.push(nextNode.iterator());
	    while (!stack.isEmpty() && !stack.peek().hasNext()) {
		stack.pop();
	    }
	    return nextNode;
	} else {
	    return null;
	}
    }
}

class CompositeBFSIterator implements Iterator<Node> {

    private List<Node> list1;
    private List<Node> list2;
    int cursor = 0;

    public CompositeBFSIterator(Node root) {
	list1 = new ArrayList<Node>();
	list2 = new ArrayList<Node>();
	list1.add(root);
    }

    @Override
    public boolean hasNext() {
	return !list1.isEmpty();
    }

    @Override
    public Node next() {
	if (hasNext()) {
	    Node current = list1.get(cursor++);
	    Iterator<Node> itr = current.iterator();
	    while(itr.hasNext()){
		list2.add(itr.next());
	    }
	    trySwitch();
	    return current;
	} else {
	    return null;
	}
    }

    private void trySwitch() {
	if (cursor == list1.size()) {
	    list1 = new ArrayList<Node>(list2);
	    list2.clear();
	    cursor = 0;
	}
    }
}
