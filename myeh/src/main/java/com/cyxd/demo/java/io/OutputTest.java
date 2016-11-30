package com.cyxd.demo.java.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputTest {

    public static void main(String[] args) throws IOException {
	
	
	OutputStream out1 = new BufferedOutputStream(null);
	
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	byte[] bs = "我是好人".getBytes("UTF-8");
	System.out.println("bs -->" + bs);
	out.write(bs);
//	BufferedOutputStream bufout = new BufferedOutputStream(out);
//	bufout.write("adsfasdf".getBytes("UTF-8"));
	
	System.out.println("out ------>" + out.toString("UTF-8"));
	
//	ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
//	byte[] bs2 = new byte[bs.length];
//	int cc = 0;
//	while((cc = in.read()) != -1){
//	    System.out.println(cc);
//	}
//	int len = in.read(bs2);
//	for (int i = 0; i < len; i++) {
//	    System.out.print(bs[i]);
//	}
    }

}
