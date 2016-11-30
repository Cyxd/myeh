package com.cyxd.bog.webapp.configuration;

import static com.cyxd.bog.webapp.configuration.Constant.FILE_SIZE_THRESHOLD;
import static com.cyxd.bog.webapp.configuration.Constant.FILTER_MAPPING_SPRING_SECURITY;
import static com.cyxd.bog.webapp.configuration.Constant.FILTER_NAME_SPRING_SECURITY;
import static com.cyxd.bog.webapp.configuration.Constant.MAX_FILE_UPLOAD_SIZE;
import static com.cyxd.bog.webapp.configuration.Constant.MAX_REQUEST_SIZE;
import static com.cyxd.bog.webapp.configuration.Constant.SCAN_PACKAGE_NAME_CONTROLLER;
import static com.cyxd.bog.webapp.configuration.Constant.SCAN_PACKAGE_NAME_SERVICE;
import static com.cyxd.bog.webapp.configuration.Constant.SERVLET_MAPPING_SPRING_MVC;
import static com.cyxd.bog.webapp.configuration.Constant.SERVLET_NAME_SPRING_MVC;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.cyxd.bog.webapp.configuration.mybatis.MybatisConfigurer;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.webapp.configuration.WebApplicationStartup
 * <li>ClassName: WebApplicationStartup
 * <li>CreateDateTime: 2016年11月16日 上午10:41:39
 *
 * <p>
 * Description:servlet container
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 * @since spring 3.1
 * @since javax.servlet servlet-api
 *
 * @see Constant
 * @see MVCConfigurer
 * @see ViewConfigurer
 * @see #onStartup(ServletContext)
 *
 */
public class WebApplicationStartup implements WebApplicationInitializer {

    /**
     * 启动后servlet container后，调用本方法
     */
    @Override
    public void onStartup(ServletContext servletContext)
	    throws ServletException {
	// register filter
//	addFilter(servletContext);
	// register springMvc servlet
	addServlet(servletContext);
    }

    /**
     * Spring servlet
     * 
     * @param servletContext
     */
    private void addServlet(ServletContext servletContext) {
	// application context
	AnnotationConfigWebApplicationContext webContext = createWebContext(
		MVCConfigurer.class, 
		ViewConfigurer.class,
		MybatisConfigurer.class
//		, 
//		ExceptionResolver.class,
//		BeanConfigurer.class
		);
//	AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	// registration mybatis, spring security configuration
//	webContext.register(MybatisConfigurer.class
//		,
//		MVCConfigurer.class
//		SecurityConfigurer.class
//		);
//	webContext.refresh();
	// registration listener
	servletContext.addListener(new ContextLoaderListener(webContext));
	// scan
	webContext
		.scan(SCAN_PACKAGE_NAME_CONTROLLER, SCAN_PACKAGE_NAME_SERVICE);
	// DispatcherServlet - spring mvc servlet
	ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
		SERVLET_NAME_SPRING_MVC, new DispatcherServlet(webContext));
	dispatcher.setLoadOnStartup(1);
	// springMVC 映射路径
	// dynamic.addMapping(SERVLET_MAPPING_HTML, SERVLET_MAPPING_AJAX,
	// SERVLET_MAPPING_CSS, SERVLET_MAPPING_JS, SERVLET_MAPPING_GIF,
	// SERVLET_MAPPING_JPG, SERVLET_MAPPING_PNG, SERVLET_MAPPING_ICON);
	// 映射所有
	dispatcher.addMapping(SERVLET_MAPPING_SPRING_MVC);
	dispatcher.setMultipartConfig(new MultipartConfigElement(null,
		MAX_FILE_UPLOAD_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));
	// Set whether this servlet should dispatch an HTTP OPTIONS request to
	// the #doService method.
	dispatcher.setInitParameter("dispatchOptionsRequest", "true");
	// Set whether this servlet should dispatch an HTTP TRACE request to the
	// #doService method.
	dispatcher.setInitParameter("dispatchTraceRequest", "true");
	dispatcher.setAsyncSupported(true);

    }

    /**
     * 
     * @see javax.servlet.FilterRegistration.Dynamic#addMappingForUrlPatterns(EnumSet,
     *      boolean, String...) Add a filter mapping with the given url patterns
     *      and dispatcher types.
     * 
     *      <pre>
     * Parameters: <br>
     * dispatcherTypes - filter mapping dispatcher types, or null to use DispatcherType.REQUEST<br>
     * isMatchAfter - true to match this filter mapping after declared ones in the servlet context, false to match it before <br>
     * urlPatterns - the url patterns in the mapping<br>
     * </pre>
     * 
     *      <pre>
     * Throws:<br>
     * java.lang.IllegalArgumentException - if urlPatterns is null or empty
     * java.lang.IllegalStateException - if the context is already initialized
     * </pre>
     * 
     * 
     * @param servletContext
     */
    private void addFilter(ServletContext servletContext) {
	// 设置编码
	FilterRegistration.Dynamic encodingfilterDynamic = servletContext
		.addFilter("encodingfilter", new CharacterEncodingFilter(
			"UTF-8", true));
	encodingfilterDynamic.addMappingForServletNames(
		EnumSet.of(DispatcherType.REQUEST), true, "dispatcher");

	// 加载国际化消息
	servletContext.setInitParameter(
		"javax.servlet.jsp.jstl.fmt.localizationContext", "message");

	FilterRegistration.Dynamic dynamic = servletContext.addFilter(
		FILTER_NAME_SPRING_SECURITY, new DelegatingFilterProxy());

	dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
		false, FILTER_MAPPING_SPRING_SECURITY);
    }

    /**
     * Web Application Context 创建
     * 
     * @param annotatedClasses
     * @return AnnotationConfigWebApplicationContext
     */
    private AnnotationConfigWebApplicationContext createWebContext(
	    Class<?>... annotatedClasses) {
	AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	webContext.register(annotatedClasses);
	return webContext;
    }

    // @Bean
    // public CharacterEncodingFilter characterEncodingFilter() {
    // CharacterEncodingFilter characterEncodingFilter = new
    // CharacterEncodingFilter();
    // characterEncodingFilter.setEncoding("UTF-8");
    // characterEncodingFilter.setForceEncoding(true);
    // return characterEncodingFilter;
    // }

}
