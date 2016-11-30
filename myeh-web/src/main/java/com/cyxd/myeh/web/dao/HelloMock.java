package com.cyxd.myeh.web.dao;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.cyxd.myeh.web.base.BasePojo;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.myeh.web.dao.HelloMock
 * <li>ClassName: HelloMock
 * <li>CreateDateTime: 2016年11月29日 下午4:51:59
 *
 * <p>
 * Description:SpringMock 测试用的POJO
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@SuppressWarnings("serial")
public class HelloMock extends BasePojo {

    private String id;
    private String name;

    public HelloMock() {
	super();
    }

    public HelloMock(String id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public String getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return ReflectionToStringBuilder.toString(this);
    }

}
