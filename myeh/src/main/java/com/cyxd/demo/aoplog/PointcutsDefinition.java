package com.cyxd.demo.aoplog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsDefinition {

	@Pointcut(ConstantPointcuts.POINTCUT_COM_CYXD_SERVICE)
	public void com$cyxd$$service() {
	}
	
}
