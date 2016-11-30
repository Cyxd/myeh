package com.cyxd.demo.java.util.concurrent;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsTest {

    static final int processors = Runtime.getRuntime().availableProcessors();
    static final int poolSize = 2 * processors;

    public static void main(String[] args) {
	AtomicInteger atoA = new AtomicInteger(0);
	Integer total = 200;

	System.out.println("processors -->" + processors);
	// ExecutorService exec = Executors.newCachedThreadPool();
	ExecutorService exec = Executors.newFixedThreadPool(poolSize);
	for (int i = 1; i <= 10; i++)
	    exec.execute(new MyThread(i, atoA, total));
	exec.shutdown();// 并不是终止线程的运行，而是禁止在这个Executor中添加新的任务
	System.out.println("last atoA ==>" + atoA.toString());
	System.out.println("last total ==>" + total);
    }

    public void beepForAnHour() {
	ScheduledExecutorService scheduler = Executors
		.newScheduledThreadPool(poolSize);
	final Runnable beeper = new Runnable() {
	    public void run() {
		System.out.println("beep");
	    }
	};
	final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
		beeper, 10, 10, SECONDS);
	
	scheduler.schedule(new Runnable() {
	    public void run() {
		beeperHandle.cancel(true);
	    }
	}, 60 * 60, SECONDS);
    }

}

class MyThread implements Runnable {
    private int count = 1, number;

    // private int countLocal;
    // private AtomicInteger atoALocal;

    public MyThread(int num, AtomicInteger atoA, Integer countLocal) {
	this.number = num;
	// this.atoALocal = atoA;
	// this.countLocal = countLocal;
	countLocal++;
	System.out.println("Create Thread-" + number + " ,countLocal==>"
		+ countLocal);
	System.out.println("Constructor atoA ==> " + atoA.getAndAdd(1));
    }

    public void run() {
	while (true) {
	    System.out.println("Thread-" + number + " ,countLocal==> + run "
		    + count + " time(s)");
	    System.out.println("Thread-" + number + " run " + count
		    + " time(s) Constructor atoA ==> ");
	    if (++count > 3)
		return;
	}
    }
}