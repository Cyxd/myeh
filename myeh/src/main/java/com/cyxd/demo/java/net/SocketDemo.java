package com.cyxd.demo.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketDemo {

	public static void main(String[] args) {

		try (Socket socket = new Socket("120.76.44.133", 9096);
				InputStream in = socket.getInputStream();
				OutputStream out = socket.getOutputStream();) {
			byte[] bii = new byte[1024];
			out.write(bii);
			int ii;

			while ((ii = in.read(bii)) != -1) {
				System.out.println(ii);
			}

			System.out.println(socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
