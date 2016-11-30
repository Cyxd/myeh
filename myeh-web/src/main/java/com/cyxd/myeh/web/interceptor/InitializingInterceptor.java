package com.cyxd.myeh.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 正确请求 - URI对应方法拦截器
 * @author cyxd
 *
 */
public class InitializingInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(InitializingInterceptor.class);

	/**
	 * {@inheritDoc}
	 * 使用说明：
	 * 1、本方法可以用于对请求的格式规范【比如验证请求头是否符合规则】
	 * 2、进入处理方法前，对参数格式进行拦截
	 * 3、对于不符合规则的请求，予以统一驳回本次请求，并返回“大致”请求失败原因
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("preHandle handler-->" + handler);
//			Enumeration<String> hnames = request.getHeaderNames();
//			while (hnames.hasMoreElements()) {
//				String headerName = (String) hnames.nextElement();
//				logger.info("head info --->[headerName=" + headerName + ",headerValue=" + request.getHeader(headerName)
//						+ "]");
//			}
			// response.sendError(HttpServletResponse.SC_FORBIDDEN);
			// throw new Exception("preHandle Exception!!!!!!!!");
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("postHandle handler-->" + handler);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("afterCompletion handler-->" + handler);
			if (ex != null){
				logger.info("afterCompletion ex-->" + ex.getMessage());
				request.setAttribute("error", ex.getMessage());
			}
				
		}
	}

}
