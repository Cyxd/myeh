package com.cyxd.bog.util.base;

public class MyStringUtils {

    /**
     * <p>length<br>
     * Description:取字符串的长度，英文算一个，中文算两个
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value 传入字符串
     * @return int
     *
     */
    public static int length(String value) {
	int valueLength = 0;
	String chinese = "[\u4e00-\u9fa5]";
	// 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
	for (int i = 0; i < value.length(); i++) {
	    // 获取一个字符
	    String temp = value.substring(i, i + 1);
	    // 判断是否为中文字符
	    if (temp.matches(chinese)) {
		// 中文字符长度为2
		valueLength += 2;
	    } else {
		// 其他字符长度为1
		valueLength += 1;
	    }
	}
	// 进位取整
	return valueLength;
    }

    /**
     * <p>lengthDouble<br>
     * Description:取字符串的长度，英文算一个，中文算两个
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value 传入字符串
     * @return double
     *
     */
    public static double lengthDouble(String value) {
	double valueLength = 0;
	String chinese = "[\u4e00-\u9fa5]";
	// 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
	for (int i = 0; i < value.length(); i++) {
	    // 获取一个字符
	    String temp = value.substring(i, i + 1);
	    // 判断是否为中文字符
	    if (temp.matches(chinese)) {
		// 中文字符长度为1
		valueLength += 1.0;
	    } else {
		// 其他字符长度为0.5
		valueLength += 0.5;
	    }
	}
	// 进位取整
	return Math.ceil(valueLength);
    }

}
