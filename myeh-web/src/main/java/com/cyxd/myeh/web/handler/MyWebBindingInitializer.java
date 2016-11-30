package com.cyxd.myeh.web.handler;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.myeh.web.handler.MyWebBindingInitializer
 * <li>ClassName: MyWebBindingInitializer
 * <li>CreateDateTime: 2016年11月28日 下午2:38:05
 *
 * <p>
 * Description:实现数据的绑定
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see WebBindingInitializer
 * @see #initBinder(WebDataBinder, WebRequest)
 *
 */
public class MyWebBindingInitializer implements WebBindingInitializer {

	private static final Logger logger = LoggerFactory.getLogger(MyWebBindingInitializer.class);

	/**
	 * String format is 日期格式要求
	 */
	private String format;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// print request head informations
		if (logger.isInfoEnabled()) {
			for (Iterator<String> iter = request.getHeaderNames(); iter.hasNext();) {
				String headerName = iter.next();
				logger.info("head info --->[headerName=" + headerName + ",headerValue=" + request.getHeader(headerName)
						+ "]");
			}
		}
	}

}
