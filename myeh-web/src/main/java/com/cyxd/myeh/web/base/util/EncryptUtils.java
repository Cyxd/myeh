package com.cyxd.myeh.web.base.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncryptUtils {

    // 从配置文件中获得 - 这里使用固定秘钥方式
    private static final String SITE_WIDE_SECRET = "s" + (((int) 'i') << 16)
	    + (((int) 'l') << 11) + "L";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(
	    SITE_WIDE_SECRET);

    public static String encrypt(String rawPassword) {
	return encoder.encode(rawPassword);
    }

    public static boolean match(String rawPassword, String password) {
	return encoder.matches(rawPassword, password);
    }

}
