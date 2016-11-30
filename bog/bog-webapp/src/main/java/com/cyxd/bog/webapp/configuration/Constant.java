package com.cyxd.bog.webapp.configuration;

/**
 * <p>
 * <li>ClassFullName:
 * com.cyxd.myeh.web.noweb.configuration.ConstantServletConfig
 * <li>ClassName: ConstantServletConfig
 * <li>CreateDateTime: 2016年10月13日 11:00:27
 *
 * <p>
 * Description:零XML配置，需要参数列表<br>
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see WebApplicationStartup#onStartup(javax.servlet.ServletContext)
 * @see MVCConfigurer
 * @see ViewConfigurer
 * 
 * @see #SERVLET_NAME
 * @see #MAX_FILE_UPLOAD_SIZE
 * @see #URL_VIEW_RESOLVER_PREFIX_VALUE
 * @see #URL_VIEW_RESOLVER_SUFFIX_VALUE
 * @see #REGISTRY_RESOURCE_VALUE
 * @see #REGISTRY_RESOURCE_LOCATION_VALUE
 *
 */
public class Constant {

    /**
     * String SERVLET_NAME is SpringMVC Servlet display name
     */
    static final String SERVLET_NAME_SPRING_MVC = "SpringMVC-NoneWebConfig";
    static final String SERVLET_MAPPING_SPRING_MVC = "/";
    
    static final String FILTER_NAME_SPRING_SECURITY = "springSecurityFilterChain";
    static final String FILTER_MAPPING_SPRING_SECURITY = "/*";
    
    static final String SCAN_PACKAGE_NAME_CONTROLLER = "com.cyxd.bog.webapp.controller";
    static final String SCAN_PACKAGE_NAME_SERVICE = "com.cyxd.bog.service";
    public static final String SCAN_PACKAGE_NAME_DAO = "com.cyxd.bog.dao";
    public static final String MYBATIS_MAPPER_XML_CONFIGURER = "com/cyxd/bog/webapp/configuration/mybatis/mybatis-mappers.xml";
    public static final String SCAN_PACKAGE_NAME_DAO_MAPPER = "classpath*:com/cyxd/bog/dao/mapper/**/*.xml";

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
     * long MAX_FILE_UPLOAD_SIZE is 文件最大上传路径
     */
    static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 5; // 5 Mb

    /**
     * int FILE_SIZE_THRESHOLD is 文件大小限制
     */
    static final int FILE_SIZE_THRESHOLD = 1024 * 1024; // After 1Mb

    /**
     * long MAX_REQUEST_SIZE is 请求包大小限制
     */
    static final long MAX_REQUEST_SIZE = -1L; // No request size limit

    /**
     * String URL_VIEW_RESOLVER_PREFIX_VALUE is URL view prefix
     */
    static final String VIEW_RESOLVER_JSP_PREFIX_VALUE = "/WEB-INF/jsp/";

    /**
     * String URL_VIEW_RESOLVER_SUFFIX_VALUE is URL view suffix
     */
    static final String VIEW_RESOLVER_JSP_SUFFIX_VALUE = ".jsp";

    /**
     * String REGISTRY_RESOURCE_VALUE is static resource
     */
    static final String REGISTRY_RESOURCE_VALUE = "/resources/**/*";

    /**
     * String REGISTRY_RESOURCE_LOCATION_VALUE is static resource location main
     */
    static final String REGISTRY_RESOURCE_LOCATION_VALUE = "/WEB-INF/resources/";

}
