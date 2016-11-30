package com.cyxd.bog.webapp.configuration;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Component会自动导入SpringConfig.java中已经加载过的*.properties文件内容到 Environment中。
//@Component
public class GlobalParams {

    @Autowired
    Environment env;

    public static int KEY_PAGE_ROWS = 12;

    // 定义允许上传的文件扩展名
    public static final HashMap<String, String> uploadExtMap = new HashMap<String, String>();

    @PostConstruct
    public void init() {
	KEY_PAGE_ROWS = Integer.parseInt(env.getProperty("page.rows", "12"));
    }

}
