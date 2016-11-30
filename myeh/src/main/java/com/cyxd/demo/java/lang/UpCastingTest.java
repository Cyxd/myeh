package com.cyxd.demo.java.lang;

import java.util.Iterator;
import java.util.Vector;

public class UpCastingTest {

    public static void main(String[] args) {
	Vector<Animal> vector = new Vector<Animal>();
	vector.add(new Dog());
	vector.add(new Cat());
	vector.add(new Pig());
	
	Iterator<Animal> iter = vector.iterator();
	while (iter.hasNext()) {
	    Animal tmp = iter.next();
	    tmp.sayHi();
	    tmp.shout();
	}
	
    }

}

interface Animal {

    public void sayHi();

    public void shout();

}

class Dog implements Animal {

    @Override
    public void sayHi() {
	System.out.println("wang");
    }

    @Override
    public void shout() {
	System.out.println("wang wang wang");
    }

}

class Cat implements Animal {

    @Override
    public void sayHi() {
	System.out.println("miao");
    }

    @Override
    public void shout() {
	System.out.println("miao miao miao");
    }

}

class Pig implements Animal {

    @Override
    public void sayHi() {
	System.out.println("ku");
    }

    @Override
    public void shout() {
	System.out.println("ku ku ku");
    }

}
