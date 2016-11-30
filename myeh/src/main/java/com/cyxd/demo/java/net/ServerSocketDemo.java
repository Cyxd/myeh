package com.cyxd.demo.java.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(1000); Socket socket = serverSocket.accept();) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
