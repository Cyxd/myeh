package com.cyxd.demo.aoplog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.cyxd.demo.aoplog.constant.SystemOperateType;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface SysteamOperationServiceLogger {

	String value();

	String type() default SystemOperateType.SELECT;

	String desc() default "";

}