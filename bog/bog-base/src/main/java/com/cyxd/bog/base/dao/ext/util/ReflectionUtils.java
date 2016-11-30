package com.cyxd.bog.base.dao.ext.util;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.base.dao.ext.util.ReflectionUtils
 * <li>ClassName: ReflectionUtils
 * <li>CreateDateTime: 2016年10月14日 9:07:17
 *
 * <p>
 * Description:反射工具类
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
public class ReflectionUtils {

    public static Field[] getAllFields(Class<?> beanClass) {
	Field[] beanFields = beanClass.getDeclaredFields();
	Class<?> beanSuperClass = beanClass.getSuperclass();
	Field[] beanSuperFields = beanSuperClass.getDeclaredFields();
	return ArrayUtils.addAll(beanFields, beanSuperFields);
    }

}
