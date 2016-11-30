package com.cyxd.myeh.web.noweb.configuration;

/**
 * <p>
 * <li>ClassFullName:
 * com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig
 * <li>ClassName: ConstantServletConfig
 * <li>CreateDateTime: 2016��10��13�� ����11:00:27
 *
 * <p>
 * Description:�ṩ��xml web project�Ļ���������Ϣ��̬������Ϣ<br>
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see WebApplicationStartup#onStartup(javax.servlet.ServletContext)
 * @see SpringMVC
 * @see ViewConfiguration
 * 
 * @see #SERVLET_NAME
 * @see #MAX_FILE_UPLOAD_SIZE
 * @see #URL_VIEW_RESOLVER_PREFIX_VALUE
 * @see #URL_VIEW_RESOLVER_SUFFIX_VALUE
 * @see #REGISTRY_RESOURCE_VALUE
 * @see #REGISTRY_RESOURCE_LOCATION_VALUE
 *
 */
public class ConstantServletConfig {

    /**
     * String SERVLET_NAME is SpringMVC Servlet����
     */
    static final String SERVLET_NAME = "SpringMVC-NoneWebConfig";
    
    static final String SERVLET_MAPPING_ALL = "/";

    /**
     * String SERVLET_MAPPING_HTML is suffix *.html, *.ajax, *.css, *.js, *.gif, *.jpg, *.png, *.icon
     * of url mapping
     */
    static final String SERVLET_MAPPING_HTML = "*.html";
    static final String SERVLET_MAPPING_AJAX = "*.ajax";
    static final String SERVLET_MAPPING_CSS = "*.css";
    static final String SERVLET_MAPPING_JS = "*.js";
    static final String SERVLET_MAPPING_GIF = "*.gif";
    static final String SERVLET_MAPPING_JPG = "*.jpg";
    static final String SERVLET_MAPPING_PNG = "*.png";
    static final String SERVLET_MAPPING_ICON = "*.icon";

    /**
     * long MAX_FILE_UPLOAD_SIZE is �ϴ��ļ�����޶�ֵ
     */
    static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 5; // 5 Mb

    /**
     * int FILE_SIZE_THRESHOLD is �����ļ����ֵ
     */
    static final int FILE_SIZE_THRESHOLD = 1024 * 1024; // After 1Mb

    /**
     * long MAX_REQUEST_SIZE is �������ݰ��޶���С����
     */
    static final long MAX_REQUEST_SIZE = -1L; // No request size limit

    /**
     * String URL_VIEW_RESOLVER_PREFIX_VALUE is URL view prefix
     */
    static final String URL_VIEW_RESOLVER_PREFIX_VALUE = "/WEB-INF/";

    /**
     * String URL_VIEW_RESOLVER_SUFFIX_VALUE is URL view suffix
     */
    static final String URL_VIEW_RESOLVER_SUFFIX_VALUE = ".jsp";

    /**
     * String REGISTRY_RESOURCE_VALUE is static resource
     */
    static final String REGISTRY_RESOURCE_VALUE = "/resources/**/*";

    /**
     * String REGISTRY_RESOURCE_LOCATION_VALUE is static resource location main
     */
    static final String REGISTRY_RESOURCE_LOCATION_VALUE = "/WEB-INF/resources/";

}
