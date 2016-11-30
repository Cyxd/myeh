package com.cyxd.myeh.web;

public class HelloMaven {

	private String name = "name";
	private static String wrapperName = "wrappername";

	public void setSomeOne() {
		System.out.println(name);
		System.out.println(wrapperName);
	}

	public static void main(String[] args) {

		new HelloMaven().setSomeOne();

	}

	public static class MavenWarper {

		public void setSomeTwo() {
			System.out.println(wrapperName);
		}

	}

}
