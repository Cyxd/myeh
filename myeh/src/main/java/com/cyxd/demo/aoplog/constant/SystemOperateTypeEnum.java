package com.cyxd.demo.aoplog.constant;

public enum SystemOperateTypeEnum {

	// ADD('A'), MODIFY('M'), DELETE('D'), SELECT('S'),
	ADD("添加"), MODIFY("修改"), DELETE("删除"), SELECT("查询");

	private String context;

	SystemOperateTypeEnum() {
	}

	SystemOperateTypeEnum(String c) {
		this.context = c;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
