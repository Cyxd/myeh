package com.cyxd.bog.base.dao.ext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.base.dao.ext.annotation.Required
 * <li>ClassName: Required
 * <li>CreateDateTime: 2016年10月14日 10:35:40
 *
 * <p>
 * Description:是否必须
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {

    boolean value() default true;

}
