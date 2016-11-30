package com.cyxd.demo.aoplog;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import com.cyxd.demo.aoplog.annotation.SysteamOperationServiceLogger;
import com.cyxd.demo.aoplog.po.Logger;
import com.cyxd.demo.aoplog.service.LoggerService;
import com.cyxd.util.DateUtils;

/**
 * @author cyxd
 *
 */
//@Aspect
public class OptLogger {

	@Resource
	LoggerService loggerService;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OptLogger.class);

	@Around("PointcutsDefinition.com$cyxd$$service()")
	public Object loggerOpt(ProceedingJoinPoint pjp) throws Throwable {
		// 获取要执行的方法名和目标对象类型
		String methodName = pjp.getSignature().getName();
		String clazzName = pjp.getTarget().getClass().getSimpleName();

		System.out.println("=========  操作日志记录  =========");

		// 这里使用了struts2的ActionContext，可以 方便的取出Session中的操作用户信息
		// Map<String, Object> session = (Map<String, Object>)
		// ActionContext.getContext().getSession();
		// username = (String) session.get("username");

		// Spring mvc
		// HttpServletRequest request = ((ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes()).getRequest();
		// HttpSession session = request.getSession();

		// 后台打印，如果需要写入数据库，编写相应代码就可以完成操作了
		System.out.println("Time:" + new Date().toString());
		// System.out.println("User:" + username);
		System.out.println("Class:" + clazzName);
		System.out.println("Method:" + methodName);

		System.out.println("Invoke Before ----------");
		// 调用目标对象的方法
		StopWatch stopWatch = new StopWatch(String.format("MethodName: %s", methodName));
		stopWatch.start();
		Object retVal = pjp.proceed();
		stopWatch.stop();
		System.out.println("Invoke After ----------");
		SysteamOperationServiceLogger sosl = getServiceMethodAnnotation(pjp);
		String operate = sosl.value();
		String operateType = sosl.type();
		String operator = "老王";
		String operateIpAddr = "";

		int i1 = loggerService.add(new Logger(operate, operateType, operator, DateUtils.currDateTime(), operateIpAddr,
				stopWatch.getTotalTimeMillis()));
		if (i1 == 1)
			logger.debug("日志写数据库完成");
		return retVal;
	}

	public static SysteamOperationServiceLogger getServiceMethodAnnotation(JoinPoint joinPoint) throws Exception {
		Object[] arguments = joinPoint.getArgs();
		Method[] methods = Class.forName(joinPoint.getTarget().getClass().getName()).getMethods();
		SysteamOperationServiceLogger anno = null;
		for (Method method : methods) {
			if (method.getName().equals(joinPoint.getSignature().getName())) {
				if (method.getParameterTypes().length == arguments.length) {
					// description =
					// method.getAnnotation(SysteamOperationServiceLogger.class).description();
					anno = method.getAnnotation(SysteamOperationServiceLogger.class);
					break;
				}
			}
		}
		return anno;
	}

}
