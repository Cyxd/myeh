package com.cyxd.rmi.myrmi.demo;

import java.rmi.RemoteException;

//UnicastRemoteObject用于导出的远程对象和获得与该远程对象通信的存根。 
public class ServiceImpl implements IService {

	private String sName;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
	
	public ServiceImpl() throws RemoteException {
		super();
	}

	public ServiceImpl(String name) throws RemoteException {
		this.sName = name;
	}

	@Override
	public String service(String content) throws RemoteException {
		return "server >>  " + sName + content;
	}

}
