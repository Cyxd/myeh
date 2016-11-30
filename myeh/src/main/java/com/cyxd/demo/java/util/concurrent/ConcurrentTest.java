package com.cyxd.demo.java.util.concurrent;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ConcurrentTest {

    public static void main(String[] args) {

	MyTask mytk = new MyTask(1);
	int increId = 1;
	for (int i = 0; i < 100; i++) {
	    new Thread(new MyThead(increId, mytk)).start();
	}
	System.out.println("last mytk ==> " + mytk);
	System.out.println("last increId ==> " + increId);
    }

}

class MyTask {

    private int taskCompletedCount;

    public MyTask() {
    }

    public MyTask(int taskCompletedCount) {
	this.taskCompletedCount = taskCompletedCount;
    }

    public MyTask taskIncrement() {
	synchronized (this) {
	    taskCompletedCount++;
	    this.notifyAll();
	}
	return this;
    }

    @Override
    public String toString() {
	return ReflectionToStringBuilder.toString(this);
    }

}

class MyThead implements Runnable {

    MyTask mytk;
    int increId;

    public MyThead() {
	super();
    }

    public MyThead(int increId, MyTask mytk) {
	this.increId = increId;
	this.mytk = mytk;
    }

    public MyThead(MyTask mytk) {
	this.mytk = mytk;
    }

    @Override
    public void run() {
//	System.out.println("Current Thread Info ->"
//		+ Thread.currentThread().getId() + " -- "
//		+ Thread.currentThread().getName() + " Incremented Task -> "
//		+ mytk.taskIncrement());
	System.out.println("Current Thread Info ->"
		+ Thread.currentThread().getId() + " -- "
		+ Thread.currentThread().getName() + " Incremented Task -> "
		+ this.increId);
	synchronized (this) {
	    this.increId++;
	    this.notifyAll();
	}
    }

}
