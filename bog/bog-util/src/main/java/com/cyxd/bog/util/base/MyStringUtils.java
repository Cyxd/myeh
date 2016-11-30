package com.cyxd.bog.util.base;

public class MyStringUtils {

    /**
     * <p>length<br>
     * Description:ȡ�ַ����ĳ��ȣ�Ӣ����һ��������������
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value �����ַ���
     * @return int
     *
     */
    public static int length(String value) {
	int valueLength = 0;
	String chinese = "[\u4e00-\u9fa5]";
	// ��ȡ�ֶ�ֵ�ĳ��ȣ�����������ַ�����ÿ�������ַ�����Ϊ2������Ϊ1
	for (int i = 0; i < value.length(); i++) {
	    // ��ȡһ���ַ�
	    String temp = value.substring(i, i + 1);
	    // �ж��Ƿ�Ϊ�����ַ�
	    if (temp.matches(chinese)) {
		// �����ַ�����Ϊ2
		valueLength += 2;
	    } else {
		// �����ַ�����Ϊ1
		valueLength += 1;
	    }
	}
	// ��λȡ��
	return valueLength;
    }

    /**
     * <p>lengthDouble<br>
     * Description:ȡ�ַ����ĳ��ȣ�Ӣ����һ��������������
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param value �����ַ���
     * @return double
     *
     */
    public static double lengthDouble(String value) {
	double valueLength = 0;
	String chinese = "[\u4e00-\u9fa5]";
	// ��ȡ�ֶ�ֵ�ĳ��ȣ�����������ַ�����ÿ�������ַ�����Ϊ2������Ϊ1
	for (int i = 0; i < value.length(); i++) {
	    // ��ȡһ���ַ�
	    String temp = value.substring(i, i + 1);
	    // �ж��Ƿ�Ϊ�����ַ�
	    if (temp.matches(chinese)) {
		// �����ַ�����Ϊ1
		valueLength += 1.0;
	    } else {
		// �����ַ�����Ϊ0.5
		valueLength += 0.5;
	    }
	}
	// ��λȡ��
	return Math.ceil(valueLength);
    }

}
