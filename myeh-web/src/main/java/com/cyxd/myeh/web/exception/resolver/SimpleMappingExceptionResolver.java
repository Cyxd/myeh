package com.cyxd.myeh.web.exception.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cyxd.myeh.web.exception.AuthenticationFailureException;

/**
 * 全局异常处理器<br>
 * 可自动识别本次http请求是AJAX请求，或者视图请求<br>
 * 如果是AJAX请求，则返回JSON字符串
 * 如果是视图请求，则返回绑定错误数据模板
 * @author cyxd
 *
 */
public class SimpleMappingExceptionResolver implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(SimpleMappingExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mav = null;
		if (logger.isInfoEnabled()) {
			logger.info("resolveException -->" + ex.getMessage());
		}
		/**
		 * TODO 根据Handler的注解来判断<br>
		 * 1、如果是Rest接口，则返回Json字符串 2、如果是视图接口，则返回绑定数据的模板
		 */
		if (isAjaxRequest(request, handler)) {
			mav = new ModelAndView("exception-json");
		} else {
			mav = new ModelAndView("exception-view");
			// 处理时Ajax
			// 处理字符串
			if (ex != null && ex instanceof AuthenticationFailureException) {
				mav.addObject("error", ex.getMessage());
			}
		}
		return mav;
	}

	/**
	 * 判断依据：
	 * 1、判断请求头是否包含x-reqeusted-with=xmlhttprequest键值对
	 * 2、某些情况下，例如是模拟的http请求，并未在请求头中写入ajax标志信息时，<br>
	 * 需要根据本次请求的URI对应的方法，以及数据格式（produces数组信息）
	 * 权重顺序为：Type是否有@RestController -> 方法是否有@ResponseBody -> 方法的@RequestMapping#produces数组信息
	 * 3、默认是返回true
	 *  
	 * @param request
	 * @param handler
	 * @return 如果是ajax请求，则返回false；反之亦然
	 */
	private boolean isAjaxRequest(HttpServletRequest request, Object handler) {
		return false;
	}

}