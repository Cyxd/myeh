package com.cyxd.rmi.myrmi.demo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) {
		try {
			// 实例化实现了IService接口的远程服务ServiceImpl对象
			IService service02 = new ServiceImpl("service02");
			UnicastRemoteObject.exportObject(service02, 0);
			LocateRegistry.createRegistry(2001).rebind("service03", service02);

			// 初始化命名空间
			// Context namingContext = new InitialContext();
			// 将名称绑定到对象,即向命名空间注册已经实例化的远程服务对象
			// namingContext.rebind("rmi://localhost/service02", service02);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("服务器向命名表注册了1个远程服务对象！");
	}

}
