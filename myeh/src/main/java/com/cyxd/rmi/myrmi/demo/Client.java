package com.cyxd.rmi.myrmi.demo;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {

	public static void main(String[] args) {
		try {
//			String url = "rmi://localhost/";
//			Context namingContext = new InitialContext();
//			// 检索指定的对象。 即找到服务器端相对应的服务对象存根
//			IService service02 = (IService) namingContext.lookup(url
//					+ "service03");
//			Class stubClass = service02.getClass();
//			System.out.println(service02 + " 是 " + stubClass.getName()
//					+ " 的实例！");
//			// 获得本底存根已实现的接口类型
//			Class[] interfaces = stubClass.getInterfaces();
//			for (Class c : interfaces) {
//				System.out.println("存根类实现了 " + c.getName() + " 接口！");
//			}
//			System.out.println(service02.service("你好！"));
			
			IService iser = (IService) LocateRegistry.getRegistry("localhost", 2001).lookup("service03");
			System.out.println(iser.service("我是调用Server端的方法》。。"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
