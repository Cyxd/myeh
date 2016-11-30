package com.cyxd.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:/spring/application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="txManager",defaultRollback=true)
public class SpringJUnit4ClassRunnerBase {

	protected Logger logger = LoggerFactory.getLogger(super.getClass());

	public SpringJUnit4ClassRunnerBase() {
	}

}