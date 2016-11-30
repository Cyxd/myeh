package com.cyxd.bog.util.base;

public class MyGenericValidator {

    /**
     * <p>
     * maxLength<br>
     * Description:验证输入字符串是否是小于等于最大值，中文算两个长度，英文算一个
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value
     *            需判断的字符串
     * @param max
     *            最大阀值
     * @return boolean
     *
     * @see MyStringUtils#length(String)
     * 
     */
    public static boolean maxLength(String value, int max) {
	return MyStringUtils.length(value) <= max;
    }

    /**
     * <p>
     * minLength<br>
     * Description:验证输入字符串是否是大于等于最大值，中文算两个长度，英文算一个
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value
     *            需判断的字符串
     * @param min
     *            最大阀值
     * @return boolean
     * 
     * @see MyStringUtils#length(String)
     *
     */
    public static boolean minLength(String value, int min) {
	return MyStringUtils.length(value) >= min;
    }

}
