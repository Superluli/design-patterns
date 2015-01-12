package com.superluli.designpatterns.command;

import java.util.Arrays;

/**
 * This pattern decouples invoker and receiver, it's suitable for situation
 * where we need features on invocations such as queue/undo/redo/combinations
 */
public class CommandExample {

    public static void main(String[] args) {

	new SingleCommandInvoker(new SampleCommand1().setReceiver(new SampleReceiver1())).invoke();

	MultipleCommandInvoker mInvoker = new MultipleCommandInvoker(3);
	mInvoker.setCommand(0, new AbstractCommand() {
	    @Override
	    public void execute() {
		System.out.println("command0 executed");
		receiver.onCommandExecuted();
	    }
	}.setReceiver(new SampleReceiver1()));
	mInvoker.setCommand(1, new AbstractCommand() {
	    @Override
	    public void execute() {
		System.out.println("command1 executed");
		receiver.onCommandExecuted();
	    }
	}.setReceiver(new SampleReceiver1()));
	mInvoker.setCommand(2, new AbstractCommand() {
	    @Override
	    public void execute() {
		System.out.println("command2 executed");
		receiver.onCommandExecuted();
	    }
	}.setReceiver(new SampleReceiver1()));
	mInvoker.invoke(0);
	mInvoker.invoke(1);
	mInvoker.invoke(2);

    }
}

interface Command {
    void execute();

    Command setReceiver(Receiver r);
}

abstract class AbstractCommand implements Command {

    Receiver receiver;

    @Override
    public Command setReceiver(Receiver r) {
	this.receiver = r;
	return this;
    }
}

interface Receiver {
    void onCommandExecuted();
}

class SampleCommand1 extends AbstractCommand {

    @Override
    public void execute() {
	System.out.println("Command1 being executed!");
	receiver.onCommandExecuted();
    }
}

class SingleCommandInvoker {

    Command command;

    public SingleCommandInvoker(Command c) {
	this.command = c;
    }

    void invoke() {
	command.execute();
    }
}

class MultipleCommandInvoker {

    Command[] commands;

    public MultipleCommandInvoker(int n) {
	commands = new Command[n];
	Command nullCommand = new AbstractCommand() {
	    @Override
	    public void execute() {
		System.out.println("null command, no receiver");
	    }
	};
	Arrays.fill(commands, nullCommand);
    }

    void setCommand(int index, Command c) {
	commands[index] = c;
    }

    void invoke(int index) {
	commands[index].execute();
    }
}

class SampleReceiver1 implements Receiver {

    @Override
    public void onCommandExecuted() {
	System.out.println("I saw command executed! I'll do my job!");
    }
}
