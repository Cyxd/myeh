package com.cyxd.bog.webapp.configuration;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.common.collect.ImmutableList;

//声明spring要加载类中的以@bean标注的bean
//@Configuration
// 支持mvc
//@EnableWebMvc
// 相当于<context:component-scan>
//@ComponentScan(basePackages = "com.cyxd")
// 加载.properties配置文件
//@PropertySource("classpath:sys-conf.properties")
// 加载.xml如果没有使用到额外的.xml配置文件，则无需加载
// @ImportResource({ "classpath:spring-rest-conver.xml" })
public class SpringConfigurer {

    // @Autowired
    // Environment env;

    // 设置 InternalResourceViewResolver. 为跳转页面自动加上前缀及后缀
    // @Bean
    public InternalResourceViewResolver jspViewResolver() {
	InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
	// 前缀
	jspViewResolver.setPrefix("/WEB-INF/jsp/");
	// 后缀
	jspViewResolver.setSuffix(".jsp");
	return jspViewResolver;
    }

    // 加载配置文件，加载之后，可以在 @ImportResource({ "classpath:*.xml" })导入的文中使用占位符${}
    // @Bean
    public PropertyPlaceholderConfigurer placeholderConfigurer() {
	PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
	placeholderConfigurer.setFileEncoding("UTF-8");
	// 用ClassPathResource的方式加载
	placeholderConfigurer.setLocations(new ClassPathResource(
		"sys-conf.properties"));
	return placeholderConfigurer;
    }

    /**
     * <p>
     * contentNegotiatingViewResolver<br>
     * Description: 混合视图解析分发器，用于根据确定出的不同MIME名，使用不同视图解析器解析视图
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return 混合视图解析分发器
     * 
     * @see
     * @see
     *
     */
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
	ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
	// 设置优先级
	cnvr.setOrder(1);
	// 设置默认的MIME类型，如果没有指定拓展名或请求参数，则使用此默认MIME类型解析视图

	// 根据请求参数映射到相应的MIME类型
	ContentNegotiationManager cnm = new ContentNegotiationManager(
		new ContentNegotiationStrategy() {
		    @Override
		    public List<MediaType> resolveMediaTypes(
			    NativeWebRequest webRequest)
			    throws HttpMediaTypeNotAcceptableException {
			return ImmutableList.of(MediaType.TEXT_HTML,
			// MediaType.APPLICATION_ATOM_XML,
				MediaType.APPLICATION_JSON
			// MediaType.APPLICATION_OCTET_STREAM
				);
		    }
		});
	cnvr.setContentNegotiationManager(cnm);

	List<View> views = ImmutableList.of();
	views.add(new InternalResourceView());
	views.add(new MappingJackson2JsonView());
	// 设置默认的候选视图，如果有合适的MIME类型，将优先从以下选择视图，找不到再在整个Spring容器里寻找已注册的合适视图
	cnvr.setDefaultViews(views);

	// 设施候选视图解析器
	List<ViewResolver> viewResolvers = ImmutableList.of();
	viewResolvers.add(new ViewResolver() {
	    @Override
	    public View resolveViewName(String viewName, Locale locale)
		    throws Exception {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	    }
	});
	
	cnvr.setViewResolvers(viewResolvers);
	return cnvr;
    }
}
