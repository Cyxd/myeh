package com.cyxd.demo.java.lang;

import java.util.Objects;

public class ObjectTest {
    
    public static void main(String[] args) {
	
	Integer a = 2,b = 2;
	int a1 = 2,b1 = 2;
	System.out.println(a == b);
	System.out.println(Objects.equals(a, b));
	
	System.out.println(a1 == b1);
	System.out.println(Objects.equals(a1, b1));
	
    }

}
