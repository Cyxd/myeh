package com.cyxd.myeh.web.noweb.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StreamTest {

    public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
//	Class<?> respCls = HttpServletResponse.class;
//	Method getSos = respCls.getMethod("getOutputStream()", null);
//	getSos.setAccessible(true);
//	getSos.invoke(respCls, null);
	

//	OutputStream out1 = new BufferedOutputStream(null);
	
	HttpServletResponse resp = null;
	ServletOutputStream out0 = resp.getOutputStream();
	OutputStreamWriter osw = new OutputStreamWriter(out0);

	ByteArrayOutputStream out = new ByteArrayOutputStream();
	byte[] bs = "我是好人".getBytes("UTF-8");
	System.out.println("bs -->" + bs);
	out.write(bs);
	// BufferedOutputStream bufout = new BufferedOutputStream(out);
	// bufout.write("adsfasdf".getBytes("UTF-8"));

	System.out.println("out ------>" + out.toString("UTF-8"));

	// ByteArrayInputStream in = new
	// ByteArrayInputStream(out.toByteArray());
	// byte[] bs2 = new byte[bs.length];
	// int cc = 0;
	// while((cc = in.read()) != -1){
	// System.out.println(cc);
	// }
	// int len = in.read(bs2);
	// for (int i = 0; i < len; i++) {
	// System.out.print(bs[i]);
	// }
    }

}
