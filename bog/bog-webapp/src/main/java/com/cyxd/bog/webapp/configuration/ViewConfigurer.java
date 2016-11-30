package com.cyxd.bog.webapp.configuration;

import static com.cyxd.bog.webapp.configuration.Constant.VIEW_RESOLVER_JSP_PREFIX_VALUE;
import static com.cyxd.bog.webapp.configuration.Constant.VIEW_RESOLVER_JSP_SUFFIX_VALUE;

import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.webapp.configuration.ViewConfiguration
 * <li>ClassName: ViewConfiguration
 * <li>CreateDateTime: 2016年10月13日 11:04:37
 *
 * <p>
 * Description:
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
public class ViewConfigurer {

    /**
     * <p>
     * urlBasedViewResolver<br>
     * Description:
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return
     * 
     * @see
     * @see
     *
     */
    @Bean
    public ViewResolver urlBasedViewResolver() {
	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	viewResolver.setOrder(2);
	viewResolver.setPrefix(VIEW_RESOLVER_JSP_PREFIX_VALUE);
	viewResolver.setSuffix(VIEW_RESOLVER_JSP_SUFFIX_VALUE);
	viewResolver.setViewClass(JstlView.class);
	// for debug envirment
	viewResolver.setCache(false);
	return viewResolver;
    }

    /**
     * 限制上传文件的大小
     */
//     @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
	CommonsMultipartResolver common = new CommonsMultipartResolver();
	common.setMaxUploadSize(10 * 1024 * 1024);// 10M
	return common;
    }

    /**
     * 字符串消息转换器
     */
//     @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
//	StringHttpMessageConverter stringHttpConverter = new StringHttpMessageConverter();
//	stringHttpConverter.setSupportedMediaTypes(ImmutableList.of(MediaType
//		.parseMediaType("text/html;charset=UTF-8")));
	return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
     

    /**
     * JSON 数据处理 - 默认就是UTF-8
     */
//    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	return new MappingJackson2HttpMessageConverter();
    }
    
    /**
     * Gson 集成
     */
//    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
	return new GsonHttpMessageConverter();
    }
    

    // @Bean
    public ViewResolver tilesViewResolver() {
	UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
	urlBasedViewResolver.setOrder(1);
	urlBasedViewResolver.setViewClass(TilesView.class);
	// urlBasedViewResolver.
	return urlBasedViewResolver;
    }

    // @Bean
    public TilesConfigurer tilesConfigurer() {
	TilesConfigurer tilesConfigurer = new TilesConfigurer();
	tilesConfigurer.setDefinitions(new String[] { "classpath:tiles.xml" });
	return tilesConfigurer;
    }
}
