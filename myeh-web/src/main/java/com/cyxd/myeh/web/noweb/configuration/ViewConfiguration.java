package com.cyxd.myeh.web.noweb.configuration;

import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.URL_VIEW_RESOLVER_PREFIX_VALUE;
import static com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig.URL_VIEW_RESOLVER_SUFFIX_VALUE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.myeh.web.noweb.configuration.ViewConfiguration
 * <li>ClassName: ViewConfiguration
 * <li>CreateDateTime: 2016��10��13�� ����11:04:37
 *
 * <p>
 * Description:
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
public class ViewConfiguration {

//    @Bean
    public ViewResolver urlBasedViewResolver() {
	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	viewResolver.setOrder(2);
	viewResolver.setPrefix(URL_VIEW_RESOLVER_PREFIX_VALUE);
	viewResolver.setSuffix(URL_VIEW_RESOLVER_SUFFIX_VALUE);
	viewResolver.setViewClass(JstlView.class);
	// for debug envirment
	viewResolver.setCache(false);
	return viewResolver;
    }

    // @Bean
    // public ViewResolver tilesViewResolver() {
    // UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
    // urlBasedViewResolver.setOrder(1);
    // urlBasedViewResolver.setViewClass(TilesView.class);
    // // urlBasedViewResolver.
    // return urlBasedViewResolver;
    // }

    // @Bean
    // public TilesConfigurer tilesConfigurer() {
    // TilesConfigurer tilesConfigurer = new TilesConfigurer();
    // tilesConfigurer.setDefinitions(new String[] { classpath:tiles.xml });
    // return tilesConfigurer;
    // }
}
