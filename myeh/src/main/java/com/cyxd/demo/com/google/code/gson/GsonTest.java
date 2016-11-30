package com.cyxd.demo.com.google.code.gson;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

    public static void main(String[] args) {

	Gson gson = new GsonBuilder().serializeNulls().setVersion(2.0).create();

	Animal cat = new Animal("cat", "fish", false, true);
	Animal fish = new Animal("fish", "water", false, false);
	Animal bird = new Animal("bird", null, true, false);

	List<Animal> ans = ImmutableList.of(cat, fish, bird);
	System.out.println("ans -->" + gson.toJson(ans));
	System.out.println("cat -->" + gson.toJson(cat, Animal.class));
	System.out.println("fish -->" + gson.toJson(fish));
	System.out.println("bird -->" + gson.toJson(bird));
	
	/**
	 * 
	 */
	
	Gson gson2 = new GsonBuilder().setExclusionStrategies(new MyExclusionStrategy()).create();
	System.out.println("cat -->" + gson2.toJson(cat, Animal.class));
	
	String gStr = gson2.toJson(cat, Animal.class);
	
	Gson gson3 = new Gson();
	
    }
}

class MyExclusionStrategy implements ExclusionStrategy{

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
	return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
	return false;
    }
    
}

class Animal {

    private String subject;
    private String eat;
    private boolean isFly;
    private boolean isRun;
    
    static class AnimalNest{
	private String name;
	private String size;
    }

    public Animal() {
    }

    public Animal(String subject, String eat, boolean isFly, boolean isRun) {
	this.subject = subject;
	this.eat = eat;
	this.isFly = isFly;
	this.isRun = isRun;
    }

    public String getSubject() {
	return subject;
    }

    public String getEat() {
	return eat;
    }

    public boolean isFly() {
	return isFly;
    }

    public boolean isRun() {
	return isRun;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public void setEat(String eat) {
	this.eat = eat;
    }

    public void setFly(boolean isFly) {
	this.isFly = isFly;
    }

    public void setRun(boolean isRun) {
	this.isRun = isRun;
    }

}
