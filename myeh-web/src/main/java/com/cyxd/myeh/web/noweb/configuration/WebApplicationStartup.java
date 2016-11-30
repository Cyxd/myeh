package com.cyxd.myeh.web.noweb.configuration;

import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.FILE_SIZE_THRESHOLD;
import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.MAX_FILE_UPLOAD_SIZE;
import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.MAX_REQUEST_SIZE;
import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.SERVLET_MAPPING_ALL;
import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.SERVLET_NAME;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * <p>
 * <li>ClassFullName:
 * com.cyxd.myeh.web.noweb.configuration.WebApplicationStartup
 * <li>ClassName: WebApplicationStartup
 * <li>CreateDateTime: 2016��10��13�� ����10:39:10
 *
 * <p>
 * Description: servlet container ����ʱ���
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 * @since spring
 * @since javax.servlet servlet-api
 *
 * @see ConstantServletConfig
 * @see SpringMVC
 * @see ViewConfiguration
 * @see #onStartup(ServletContext)
 *
 */
public class WebApplicationStartup 
//implements WebApplicationInitializer 
{

    /**
     * ������ڣ�����servlet container֮��ص�������
     */
//    @Override
    public void onStartup(ServletContext servletContext)
	    throws ServletException {
	// ע��springMvc��servlet
//	this.addServlet(servletContext);
	// ע�������
	// servletContext.addFilter(arg0, arg1)
	// ע�������
	// servletContext.addListener(arg0);
    }

    /**
     * ע��Spring servlet
     * 
     * @param servletContext
     */
    private void addServlet(ServletContext servletContext) {
	// ����һ��application context
	AnnotationConfigWebApplicationContext webContext = createWebContext(
		SpringMVC.class, ViewConfiguration.class);
	// ע��spring mvc �� servlet
	Dynamic dynamic = servletContext.addServlet(SERVLET_NAME,
		new DispatcherServlet(webContext));
	// ���springMVC ������ʵ�Controller��׺
	// dynamic.addMapping(SERVLET_MAPPING_HTML, SERVLET_MAPPING_AJAX,
	// SERVLET_MAPPING_CSS, SERVLET_MAPPING_JS, SERVLET_MAPPING_GIF,
	// SERVLET_MAPPING_JPG, SERVLET_MAPPING_PNG, SERVLET_MAPPING_ICON);
	// ȫ��ͨ������ ��/��
	dynamic.addMapping(SERVLET_MAPPING_ALL);
	dynamic.setLoadOnStartup(1);
	dynamic.setMultipartConfig(new MultipartConfigElement(null,
		MAX_FILE_UPLOAD_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));
    }

    /**
     * ͨ���Զ������������ʵ��һ��Web Application Context
     * 
     * @param annotatedClasses
     * @return
     */
    private AnnotationConfigWebApplicationContext createWebContext(
	    Class... annotatedClasses) {
	AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	webContext.register(annotatedClasses);
	return webContext;
    }

}
