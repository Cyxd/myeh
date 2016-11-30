package com.cyxd.demo.java.lang;

public class LeftRightShiftTest {

    public static void main(String[] args) {
	System.out.println("left shift ->");
	int q = 1;
	System.out.println(q << 6);
	System.out.println(q << 5);
	System.out.println(q << 2);
	System.out.println((q << 0));
	System.out.println((q << 3) + (q << 1));
	System.out.println((q << 6) + (q << 5) + (q << 2));
	System.out.println((q << 9) + (q << 8) + (q << 7) + (q << 6) + (q << 5)
		+ (q << 3));

	System.out.println("right shift ->");
	q = -1;
	System.out.println(q >> 6);
	System.out.println((q >> 3) + (q >> 1));
	System.out.println((q >> 6) + (q >> 5) + (q >> 2));
	System.out.println((q >> 9) + (q >> 8) + (q >> 7) + (q >> 6) + (q >> 5)
		+ (q >> 3));

	System.out.println("unsigned right shift ->");
	q = 192;
	System.out.println(q >>> 6);
	System.out.println((q >>> 3) + (q >>> 1));
	System.out.println((q >>> 6) + (q >>> 5) + (q >>> 2));
	System.out.println((q >>> 9) + (q >>> 8) + (q >>> 7) + (q >>> 6) + (q >>> 5)
		+ (q >>> 3));
	
	System.out.println("unsigned right shift ->");
	byte w = -1;
	System.out.println(w >>> 4);
	System.out.println(w >> 4);
	
    }

}
