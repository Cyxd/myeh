package com.cyxd.demo.sun.net.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.commons.lang3.time.StopWatch;

import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

public class MyFTPClient {

	public static FtpClient connectFTP(String url, int port, String username,
			String password) { // 创建ftp
		try {
			// 创建地址
			SocketAddress addr = new InetSocketAddress(url, port);
			// 连接
			FtpClient ftp = FtpClient.create();
			ftp.connect(addr);
			// 登陆
			ftp.login(username, password.toCharArray());
			ftp.setBinaryType();
			System.out.println(ftp.getWelcomeMsg());
			return ftp;
		} catch (FtpProtocolException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void changeDirectory(FtpClient ftp, String path) {
		try {
			ftp.changeDirectory(path);
			System.out.println(ftp.getWorkingDirectory());
		} catch (FtpProtocolException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void disconnectFTP(FtpClient ftp) {
		try {
			ftp.close();
			System.out.println("disconnect success!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param localFile
	 * @param ftpFile
	 * @param ftp
	 */
	public static void upload(String localFile, String ftpFile, FtpClient ftp) {
		// 将ftp文件加入输出流中。输出到ftp上
		try (OutputStream os = ftp.putFileStream(ftpFile);
				FileInputStream fis = new FileInputStream(new File(localFile));) {
			// 创建一个缓冲区
			byte[] bytes = new byte[1024];
			int c;
			while ((c = fis.read(bytes)) != -1)
				os.write(bytes, 0, c);
			System.out.println("upload success!!");
		} catch (FtpProtocolException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文件下载
	 * 
	 * @param localFile
	 * @param ftpFile
	 * @param ftp
	 */
	public static void download(String localFile, String ftpFile, FtpClient ftp) {
		// 获取ftp上的文件
		try (InputStream is = ftp.getFileStream(ftpFile);
				FileOutputStream fos = new FileOutputStream(new File(localFile));) {
			byte[] bytes = new byte[1024];
			int i = 0;
			while ((i = is.read(bytes)) != -1)
				fos.write(bytes, 0, i);
			System.out.println("download success!!");
		} catch (FtpProtocolException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StopWatch watcher = new StopWatch();
		watcher.start();
		String ip = "120.24.217.254";
		int port = 21;
		String username = "hydra";
		String password = "1q2w3e";
		String path = "/home/hydra";
		try (FtpClient ftp = MyFTPClient.connectFTP(ip, port, username, password);) {
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("The LocalHost=====" + addr.getHostAddress());
			// 连接ftp
			System.out.println("WelcomeMsg===" + ftp.getWelcomeMsg());
			System.out.println("Current Work Path" + ftp.getWorkingDirectory());
			// 切换目录
			// MyFtp.changeDirectory(ftp, path);
			// ftp.c
			System.out.println("-----上传----");
			// MyFtp.upload("D:/aaa.txt", path + "/aaa.txt", ftp);
			// MyFtp.upload("D:/aaa.txt", ftp.getWorkingDirectory() +
			// "/aaa.txt",
			// ftp);

			MyFTPClient.upload("D:/CYXD/ftp/auto_zip_20160918170022.zip",
					ftp.getWorkingDirectory() + "/auto_zip_20160918170022.zip",
					ftp);

			System.out.println("-----下载----");
			// MyFtp.download("D:/aaa.txt", path + "home/aaa.txt", ftp);
		} catch (FtpProtocolException | IOException e) {
			e.printStackTrace();
		}
		watcher.stop();
		System.out.println("The used nano time ====" + watcher.getNanoTime());
		System.out.println("The used millisecond time ====" + watcher.getTime());
		System.out.println("The used second time ====" + watcher.getTime() / 1000L);
	}
}
