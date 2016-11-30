package com.cyxd.rmi.myrmi.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMailUtis {
	
	public static void main(String[] args) {
		EMailUtis eu = new EMailUtis();
		eu.sendMail();
	}

	public void sendMail() {
		// 收件人电子邮箱
		String to = "slil@hlzx.com";

		// 发件人电子邮箱
		String from = "xdjiemao@163.com";

		// 指定发送邮件的主机为 localhost
		String host = "smtp.163.com";

		// 获取系统属性
		Properties props = System.getProperties();

		// 设置邮件服务器
	    props.put("mail.smtp.host", host);   
	    props.put("mail.smtp.auth","true");   
//	    props.put("username","xdjiemao@163.com");   
//	    props.put("password","gb08501325LW");   

		// 获取默认session对象
		Session session = Session.getDefaultInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("xdjiemao@163.com","ssss");
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: 头部头字段
			message.setSubject("This is the Subject Line!");

			// 设置消息体
//			message.setText("这是大写的鬼东西");
//			message.setc
			message.setContent("<h1>This is actual message</h1><b>这是大写的鬼东西</b>","text/html;charset=utf-8" );

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
