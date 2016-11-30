package com.cyxd.bog.model.op;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.cyxd.bog.base.dao.ext.annotation.Column;
import com.cyxd.bog.base.dao.ext.annotation.Required;
import com.cyxd.bog.base.dao.ext.annotation.Table;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.bog.model.op.Logger
 * <li>ClassName: Logger
 * <li>CreateDateTime: 2016年10月13日 下午4:28:42
 *
 * <p>
 * Description:
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
@Table
public class Logger {

    @Column
    @Required
    private int id;
    @Column
    private String operate;
    @Column
    private String operateType;
    @Column
    private String operator;
    @Column
    private String operateDate;
    @Column
    private String operateIpAddr;

    private String orderBy;
    private String orderType;
    private String operateDateDown;
    private String operateDateUp;
    private Long methodTookTime;

    public int getId() {
	return id;
    }

    public void setId(int id) {
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

    public String getOrderBy() {
	return orderBy;
    }

    public void setOrderBy(String orderBy) {
	this.orderBy = orderBy;
    }

    public String getOrderType() {
	return orderType;
    }

    public void setOrderType(String orderType) {
	this.orderType = orderType;
    }

    public String getOperateDateDown() {
	return operateDateDown;
    }

    public void setOperateDateDown(String operateDateDown) {
	this.operateDateDown = operateDateDown;
    }

    public String getOperateDateUp() {
	return operateDateUp;
    }

    public void setOperateDateUp(String operateDateUp) {
	this.operateDateUp = operateDateUp;
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

    public Logger(String operate, String operateType, String operator,
	    String operateDate, String operateIpAddr, Long methodTookTime) {
	this.operate = operate;
	this.operateType = operateType;
	this.operator = operator;
	this.operateDate = operateDate;
	this.operateIpAddr = operateIpAddr;
	this.methodTookTime = methodTookTime;
    }

    public Logger(int id, String operate, String operateType, String operator,
	    String operateDate, String operateIpAddr) {
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
