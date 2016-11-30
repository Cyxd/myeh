package com.cyxd.util;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cyxd.demo.service.ServicerService;

public class SpringUtils {
	
	private final static String SPRING_CONTEXT = "spring/application.xml";
	
	private static ApplicationContext appContext;
	
	static{
		appContext = new ClassPathXmlApplicationContext(SPRING_CONTEXT);
	}
	
	public static ApplicationContext getAppContext(){
		return appContext;
	}
	
	@Resource ServicerService servicerService;
	
	public static void main(String[] args) {
		System.out.println(getAppContext());
		System.out.println(getAppContext().getBean("servicerServiceImpl"));
		
		SpringUtils su = new SpringUtils();
		System.out.println(su.servicerService);
		
	}

}
