package com.cyxd.bog.service.op;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
public class LoggerServiceJUnit {
    
    @Resource LoggerService loggerService;
    
    @Test
    public void testLoggerService() throws Exception {
	System.out.println("asdfasfasfsadf" + loggerService);
	
    }

}
