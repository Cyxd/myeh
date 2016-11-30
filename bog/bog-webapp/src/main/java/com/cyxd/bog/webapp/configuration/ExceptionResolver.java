package com.cyxd.bog.webapp.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

//@Configuration
public class ExceptionResolver {

//	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
		SimpleMappingExceptionResolver simpleResolver = new SimpleMappingExceptionResolver();
		simpleResolver.setDefaultErrorView("errors/500");
		simpleResolver.setDefaultStatusCode(500);
		simpleResolver.setExceptionMappings(exceptionSolver());
		simpleResolver.setStatusCodes(statusCodesSolver());
		simpleResolver.setWarnLogCategory("WARN");
		return simpleResolver;
	}

	private Properties exceptionSolver() {
		Properties prop = new Properties();
		prop.setProperty("java.lang.Exception", "errors/500");
		prop.setProperty("java.lang.Throwable", "errors/500");
		prop.setProperty("java.lang.RuntimeException", "errors/showError");
		prop.setProperty("java.sql.SQLException", "errors/showDBError");
		return prop;
	}
	
	private Properties statusCodesSolver() {
		Properties prop = new Properties();
		//4XX
		prop.setProperty("errors/400", "400");
		prop.setProperty("errors/403", "403");
		prop.setProperty("errors/404", "404");
		
		//5XX
		prop.setProperty("errors/500", "500");
		
		return prop;
	}
	
}
