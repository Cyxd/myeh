package com.cyxd.demo.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;

import com.cyxd.demo.aoplog.po.Logger;
import com.cyxd.demo.aoplog.service.LoggerService;
import com.cyxd.demo.dto.Servicer;
import com.cyxd.test.SpringJUnit4ClassRunnerBase;
import com.cyxd.util.DateUtils;

public class JUnitTest extends SpringJUnit4ClassRunnerBase {

	@Resource
	ServicerService servicerService;

	@Test
	public void testTxAdivce() throws Exception {
		servicerService.update(new Servicer("dfdf8129323d418fbed052a01daeff62", "隔壁老王----"));
	}
	
	@Test
	public void testTxAdivce_2() throws Exception {
		servicerService.add(new Servicer(UUID.randomUUID().toString().replace("-", ""), "隔壁老王14124124"));
	}
	
	@Resource
	LoggerService loggerService;
	
	@Test
	public void testTxAdivce2() throws Exception {
		Logger arg0 = new Logger();
		arg0.setOperate("lao");
		arg0.setOperateDate(DateUtils.currDateTime());
		loggerService.add(arg0);
	}

	public static void main(String[] args) throws Exception {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/application.xml","classpath:/spring-mybatis/spring-mybatis.xml");
//		ServicerService service = ctx.getBean(ServicerService.class);
//		System.out.println(ctx);
//		System.out.println(service);
//		service.update(new Servicer("96fc5f932ef547439eb5791dca4bbfd5", "隔壁老王 1111 "));
		
	}
	


}
