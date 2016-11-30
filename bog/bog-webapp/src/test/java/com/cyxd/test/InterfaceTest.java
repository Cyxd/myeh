package com.cyxd.test;

import java.lang.reflect.Constructor;

public class InterfaceTest {
	
	public static void main(String[] args) {
		
		Class<Eat> cls = Eat.class;
		Constructor<?>[] cons = cls.getConstructors();
		System.out.println("constructors" + cons);
		for (Constructor<?> constructor : cons) {
			System.out.println("constructor -->" + constructor.getName());
		}
		
		
		
	}
	

}


interface Eat{
	
	
}