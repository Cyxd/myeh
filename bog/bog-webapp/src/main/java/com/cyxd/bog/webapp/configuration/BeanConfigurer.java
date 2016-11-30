package com.cyxd.bog.webapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.cyxd.bog.webapp.configuration.interceptor.BaseInterceptor;
import com.cyxd.bog.webapp.ext.rest.handler.DefaultJacksonHttpMessageConverter;
import com.cyxd.bog.webapp.ext.rest.handler.DefaultRestErrorResolver;
import com.cyxd.bog.webapp.ext.rest.handler.RestExceptionHandler;
import com.google.common.collect.ImmutableMap;

@Configuration
@EnableWebMvc
public class BeanConfigurer extends WebMvcConfigurationSupport {

	/**
	 * 注册是拦截器是
	 * 
	 * @return
	 */
	@Bean
	public BaseInterceptor registBaseInterceptor() {
		return new BaseInterceptor();
	}

	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return super.requestMappingHandlerMapping();
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(registBaseInterceptor());
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

	// @Bean
	public AcceptHeaderLocaleResolver acceptHeaderLocaleResolver() {
		return new AcceptHeaderLocaleResolver();
	}

	// @Bean
	public DefaultJacksonHttpMessageConverter DefaultJacksonHttpMessageConverter() {
		return new DefaultJacksonHttpMessageConverter(true);// prettyPrint -
															// true
	}

	/**
	 * <p>
	 * annotationMethodHandlerExceptionResolver<br>
	 * Description: Allow Exceptions to be handled in annotated methods if
	 * desired. Otherwise fallback to the 'restExceptionResolver' below:
	 *
	 */
	// @Bean
	public AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver() {
		return new AnnotationMethodHandlerExceptionResolver();
	}

	// @Bean
	public RestExceptionHandler RestExceptionHandler() {
		RestExceptionHandler restHandler = new RestExceptionHandler();
		restHandler.setOrder(100);
		restHandler.setMessageConverters(new HttpMessageConverter[] { new DefaultJacksonHttpMessageConverter(true) });
		DefaultRestErrorResolver errorResolver = new DefaultRestErrorResolver();
		errorResolver.setLocaleResolver(new AcceptHeaderLocaleResolver());
		errorResolver.setDefaultMoreInfoUrl("xdjiemao@163.com");
		errorResolver.setExceptionMappingDefinitions(ImmutableMap
				.of("com.cyxd.bog.base.exception.UnknownResourceException", "404, _exmsg", "Throwable", "500"));
		restHandler.setErrorResolver(errorResolver);
		return restHandler;
	}

}
