package com.cyxd.bog.webapp.configuration;

import static com.cyxd.bog.webapp.configuration.Constant.REGISTRY_RESOURCE_LOCATION_VALUE;
import static com.cyxd.bog.webapp.configuration.Constant.REGISTRY_RESOURCE_VALUE;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.webapp.configuration.SpringMVC
 * <li>ClassName: SpringMVC
 * <li>CreateDateTime: 2016年10月13日 11:03:50
 *
 * <p>
 * Description:no xml webproject springmvc configuration informations.
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see Constant
 * @see WebApplicationStartup#onStartup(javax.servlet.ServletContext)
 *
 */
@Configuration
@EnableWebMvc
// @MapperScan()
public class MVCConfigurer extends WebMvcConfigurerAdapter {

	/**
	 */
	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * /WEB-INF/resources/
	 * http://host:port/projectName/WEB-INF/resources/xxx.css
	 * http://host:port/projectName/resources/xxx.css
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//		registry.addResourceHandler(REGISTRY_RESOURCE_VALUE).addResourceLocations(REGISTRY_RESOURCE_LOCATION_VALUE);
	}
}
