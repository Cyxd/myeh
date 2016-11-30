package com.cyxd.demo.aoplog.po;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Logger implements Serializable {

	private Integer id;
	private String operate;
	private String operateType;
	private String operator;
	private String operateDate;
	private String operateIpAddr;
	private Long methodTookTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateIpAddr() {
		return operateIpAddr;
	}

	public void setOperateIpAddr(String operateIpAddr) {
		this.operateIpAddr = operateIpAddr;
	}

	public Long getMethodTookTime() {
		return methodTookTime;
	}

	public void setMethodTookTime(Long methodTookTime) {
		this.methodTookTime = methodTookTime;
	}

	public Logger() {
		super();
	}

	public Logger(String operate, String operateType, String operator, String operateDate, String operateIpAddr,
			Long methodTookTime) {
		this.operate = operate;
		this.operateType = operateType;
		this.operator = operator;
		this.operateDate = operateDate;
		this.operateIpAddr = operateIpAddr;
		this.methodTookTime = methodTookTime;
	}

	public Logger(Integer id, String operate, String operateType, String operator, String operateDate,
			String operateIpAddr) {
		this.id = id;
		this.operate = operate;
		this.operateType = operateType;
		this.operator = operator;
		this.operateDate = operateDate;
		this.operateIpAddr = operateIpAddr;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
