package com.cyxd.demo.org.apache.commons;

import org.apache.commons.lang3.SystemUtils;

public class SystemUtilsTest {
	
	public static void main(String[] args) {
		
		System.out.println(SystemUtils.IS_JAVA_1_1);
		System.out.println(SystemUtils.IS_JAVA_1_2);
		System.out.println(SystemUtils.IS_JAVA_1_3);
		System.out.println(SystemUtils.IS_JAVA_1_4);
		System.out.println(SystemUtils.IS_JAVA_1_5);
		System.out.println(SystemUtils.IS_JAVA_1_6);
		System.out.println("==="+SystemUtils.IS_JAVA_1_7);
		System.out.println(SystemUtils.IS_OS_AIX);
		System.out.println(SystemUtils.IS_OS_WINDOWS_2000);
		System.out.println(SystemUtils.IS_OS_WINDOWS_8);
		System.out.println(SystemUtils.IS_OS_WINDOWS_7);
		
		System.out.println("Java_home==" + SystemUtils.JAVA_HOME);
		System.out.println("java compiler==" + SystemUtils.JAVA_COMPILER );
		System.out.println("java class path==" + SystemUtils.JAVA_CLASS_PATH );
		System.out.println("java class version==" + SystemUtils.JAVA_CLASS_VERSION );
		System.out.println("java io tempdir==" + SystemUtils.JAVA_IO_TMPDIR );
		
		System.out.println(SystemUtils.getUserDir());
		System.out.println(SystemUtils.getUserHome());
		
		System.out.println(SystemUtils.JAVA_VENDOR);
		System.out.println(SystemUtils.JAVA_VENDOR_URL);
		
		
		System.out.println(SystemUtils.USER_COUNTRY);
		System.out.println(SystemUtils.OS_VERSION);
		
		System.out.println(SystemUtils.LINE_SEPARATOR);
		
	}

}
