package com.cyxd.myeh.web.noweb.configuration;

import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.REGISTRY_RESOURCE_LOCATION_VALUE;
import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.REGISTRY_RESOURCE_VALUE;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.myeh.web.noweb.configuration.SpringMVC
 * <li>ClassName: SpringMVC
 * <li>CreateDateTime: 2016��10��13�� ����11:03:50
 *
 * <p>
 * Description:no xml webproject springmvc configuration informations.
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see ConstantServletConfig
 * @see WebApplicationStartup#onStartup(javax.servlet.ServletContext)
 *
 */
//@Configuration
//@EnableWebMvc
// ָ��controller���ڵİ���
//@ComponentScan(basePackages = { "com.cyxd.myeh.web.noweb.controller" })
public class SpringMVC 
//extends WebMvcConfigurerAdapter 
{

    /**
     * �Ǳ���
     */
//    @Override
    public void configureDefaultServletHandling(
	    final DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }

    /**
     * �����Ŀ��һЩ��Դ�ļ�����/WEB-INF/resources/����
     * ����������ʵĵ�ַ�������ƣ�http://host:port/projectName/WEB-INF/resources/xxx.css
     * ���Ǽ������¶���֮��Ϳ���������ʣ� http://host:port/projectName/resources/xxx.css �Ǳ���
     */
//    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	registry.addResourceHandler(REGISTRY_RESOURCE_VALUE)
		.addResourceLocations(REGISTRY_RESOURCE_LOCATION_VALUE);
    }
}
