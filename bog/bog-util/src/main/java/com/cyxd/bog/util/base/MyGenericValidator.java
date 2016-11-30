package com.cyxd.bog.util.base;

public class MyGenericValidator {

    /**
     * <p>
     * maxLength<br>
     * Description:��֤�����ַ����Ƿ���С�ڵ������ֵ���������������ȣ�Ӣ����һ��
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value
     *            ���жϵ��ַ���
     * @param max
     *            ���ֵ
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
     * Description:��֤�����ַ����Ƿ��Ǵ��ڵ������ֵ���������������ȣ�Ӣ����һ��
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value
     *            ���жϵ��ַ���
     * @param min
     *            ���ֵ
     * @return boolean
     * 
     * @see MyStringUtils#length(String)
     *
     */
    public static boolean minLength(String value, int min) {
	return MyStringUtils.length(value) >= min;
    }

}
