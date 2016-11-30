package com.cyxd.demo.java.lang;

import java.lang.reflect.Field;

public class IntegerTest {

    public static void main(String[] args) {
	Integer i1 = new Integer(3);
	Integer i2 = 3;
	int i3 = 3;

	System.out.println(i1 == i2);
	System.out.println(i1 == i3);
	System.out.println(i2 == i3);

	System.out.println(i1.equals(i2));
	// false
	// true
	// true
	// true

	System.out.println("Integer.SIZE ==>" + Integer.SIZE);

	System.out.println("Integer.MAX_VALUE ->" + Integer.MAX_VALUE);
	System.out.println(Integer.MAX_VALUE + 1);
	System.out.println("Integer.MIN_VALUE ->" + Integer.MIN_VALUE);
	System.out.println(Integer.MIN_VALUE - 1);

	System.out.println((1 << 31) - 1);
	
	System.out.println("1 << (Integer.SIZE - 2) --> " + (1 << (Integer.SIZE - 2))  +" binary -> "+Integer.toBinaryString(1 << (Integer.SIZE - 2)));
	System.out.println("000000000000000000000000000000".length());
	System.out.println(Math.pow(2, 30));
	
	
	System.out.println(" ------------------>Integer Cache");
	
	Class<?> integerCacheCls = Integer.class.getDeclaredClasses()[0];
	try {
	    Field cacheField = integerCacheCls.getDeclaredField("cache");
	    cacheField.setAccessible(true);
	    Integer[] cache = (Integer[])cacheField.get(integerCacheCls);
//	    System.out.println(cache + " " + cache.length);
//	    for (Integer integer : cache) {
//		System.out.println("integer --->" + integer);
//	    }
	    cache[132] = cache[133]; //更改132 索引值对应的值
	    int a = 2;
	    int b = a + a;
	    System.out.printf("%d + %d = %d",a,a,b); //2 + 2 = 5
	    
	} catch (NoSuchFieldException e) {
	    e.printStackTrace();
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	}
	
    }

}
