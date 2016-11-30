package com.cyxd.demo.java.lang;

public class CharacterTest {

	public static void main(String[] args) {

		char c1 = 'a';
		char c2 = 'a';
		Character c11 = new Character('a');
		Character c21 = new Character('a');

		System.out.println(c1 == c2);
		System.out.println(c11 == c21);

		CharacterTest.ddd dd = new CharacterTest.ddd();
		System.out.println(dd.r);
		
		CharacterTest ct = new CharacterTest();
		
//		ccc c = new ccc();
		ccc c = ct.new ccc();
		System.out.println(c.c);
		System.out.println(new CharacterTest.ddd().r);
		
		abstract class innerMethodMain{
			
		}
		
		class innerMethodDefaultMain{
			
		}
		
		final class innerMethodFinalMain{
			
		}
		
		int iii = (1 << 6) + (1 << 5) + (1 << 2);
		final int fiii = (1 << 6) + (1 << 5) + (1 << 2);
		new default222() {
			@Override
			public void eat() {
				System.out.println("default222 -->eat()" + fiii);
			}
		}.eat();
		
		new default333() {
			@Override
			void aeat() {
				System.out.println("default333 -->eat()" + fiii);
			}
		}.aeat();

	}
	
	private char cccccc = 'd';
	private static char ssssss = 's';
	public static void staticMethod1(){
//		CharacterTest ct = new CharacterTest();
//		System.out.println(ct.cccccc);
		
		abstract class innerMethodStatic{
			
		}
		
		class innerMethodDefaultStatic{
			
		}
		
		final class innerMethodFinalStatic{
			
		}
	}
	
	public void innerMethodTest(){
		abstract class innerMethod{
			
		}
		
		class innerMethodDefault{
			
		}
		
		final class innerMethodFinal{
			
		}
	}
	
	public class ccc{
		public char c = 'c';
		
		private final char d = 'd';
		
		public void ddd(){
			c = CharacterTest.this.cccccc;
			c = CharacterTest.ssssss;
		}
		
	}

	private static class ddd {

		char r = 'r';

		public char getR() {
			return r;
		}

		public void setR(char r) {
			this.r = r;
		}

	}

}

class default111{
	
}

interface default222{
	void eat();
}
abstract class default333{
	abstract void aeat();
}
